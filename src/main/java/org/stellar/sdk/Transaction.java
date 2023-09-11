package org.stellar.sdk;

import static com.google.common.base.Preconditions.checkArgument;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import lombok.NonNull;
import org.stellar.sdk.xdr.AccountID;
import org.stellar.sdk.xdr.ClaimableBalanceID;
import org.stellar.sdk.xdr.ClaimableBalanceIDType;
import org.stellar.sdk.xdr.DecoratedSignature;
import org.stellar.sdk.xdr.EnvelopeType;
import org.stellar.sdk.xdr.Hash;
import org.stellar.sdk.xdr.HashIDPreimage;
import org.stellar.sdk.xdr.Int64;
import org.stellar.sdk.xdr.SequenceNumber;
import org.stellar.sdk.xdr.SorobanTransactionData;
import org.stellar.sdk.xdr.TransactionEnvelope;
import org.stellar.sdk.xdr.TransactionSignaturePayload;
import org.stellar.sdk.xdr.TransactionV0;
import org.stellar.sdk.xdr.TransactionV0Envelope;
import org.stellar.sdk.xdr.TransactionV1Envelope;
import org.stellar.sdk.xdr.Uint32;
import org.stellar.sdk.xdr.XdrDataOutputStream;
import org.stellar.sdk.xdr.XdrUnsignedInteger;

/**
 * Represents <a href="https://developers.stellar.org/docs/glossary/transactions/"
 * target="_blank">Transaction</a> in Stellar network.
 */
public class Transaction extends AbstractTransaction {
  private final long mFee;
  private final String mSourceAccount;
  private final long mSequenceNumber;
  private final Operation[] mOperations;
  private final Memo mMemo;
  private final TransactionPreconditions mPreconditions;
  private final SorobanTransactionData mSorobanData;
  private EnvelopeType envelopeType = EnvelopeType.ENVELOPE_TYPE_TX;

  Transaction(
      AccountConverter accountConverter,
      @NonNull String sourceAccount,
      long fee,
      long sequenceNumber,
      @NonNull Operation[] operations,
      Memo memo,
      TransactionPreconditions preconditions,
      SorobanTransactionData sorobanData,
      Network network) {
    super(accountConverter, network);
    this.mSourceAccount = sourceAccount;
    this.mSequenceNumber = sequenceNumber;
    this.mOperations = operations;
    checkArgument(operations.length > 0, "At least one operation required");
    this.mPreconditions = preconditions;
    this.mFee = fee;
    this.mMemo = memo != null ? memo : Memo.none();
    this.mSorobanData = sorobanData != null ? new SorobanDataBuilder(sorobanData).build() : null;
  }

  // setEnvelopeType is only used in tests which is why this method is package protected
  void setEnvelopeType(EnvelopeType envelopeType) {
    this.envelopeType = envelopeType;
  }

  @Override
  public byte[] signatureBase() {
    TransactionSignaturePayload.TransactionSignaturePayloadTaggedTransaction taggedTransaction =
        new TransactionSignaturePayload.TransactionSignaturePayloadTaggedTransaction();
    taggedTransaction.setDiscriminant(EnvelopeType.ENVELOPE_TYPE_TX);
    taggedTransaction.setTx(this.toV1Xdr(accountConverter));
    return getTransactionSignatureBase(taggedTransaction, mNetwork);
  }

  public String getSourceAccount() {
    return mSourceAccount;
  }

  public long getSequenceNumber() {
    return mSequenceNumber;
  }

  public Memo getMemo() {
    return mMemo;
  }

  /**
   * Get the Soroban data for the transaction.
   *
   * @return SorobanTransactionData if the transaction includes SorobanData, otherwise null.
   */
  public SorobanTransactionData getSorobanData() {
    return mSorobanData;
  }

  /**
   * Get the pre-conditions for the transaction
   *
   * @return TransactionPreconditions
   */
  public TransactionPreconditions getPreconditions() {
    return mPreconditions;
  }

  /**
   * Gets the time bounds defined for the transaction.
   *
   * @return TimeBounds
   */
  public TimeBounds getTimeBounds() {
    return mPreconditions.getTimeBounds();
  }

  /** Returns fee paid for transaction in stroops (1 stroop = 0.0000001 XLM). */
  public long getFee() {
    return mFee;
  }

  /** Returns operations in this transaction. */
  public Operation[] getOperations() {
    return mOperations;
  }

  /**
   * Returns the claimable balance ID for the CreateClaimableBalanceOperation at the given index
   * within the transaction.
   */
  public String getClaimableBalanceId(int index) throws IOException {
    if (index < 0 || index >= mOperations.length) {
      throw new IllegalArgumentException(
          "index: " + index + " is outside the bounds of the operations within this transaction");
    }
    if (!(mOperations[index] instanceof CreateClaimableBalanceOperation)) {
      throw new IllegalArgumentException(
          "operation at index "
              + index
              + " is not of type CreateClaimableBalanceOperation: "
              + mOperations[index].getClass());
    }

    // We mimic the relevant code from Stellar Core
    // https://github.com/stellar/stellar-core/blob/9f3cc04e6ec02c38974c42545a86cdc79809252b/src/test/TestAccount.cpp#L285
    //
    // Note that the source account must be *unmuxed* for this to work.

    Uint32 opIndex = new Uint32(new XdrUnsignedInteger(index));
    SequenceNumber sequenceNumber = new SequenceNumber(new Int64(getSequenceNumber()));
    AccountID sourceAccount =
        StrKey.muxedAccountToAccountId(AccountConverter.disableMuxed().encode(getSourceAccount()));
    HashIDPreimage.HashIDPreimageOperationID operationID =
        new HashIDPreimage.HashIDPreimageOperationID.Builder()
            .opNum(opIndex)
            .seqNum(sequenceNumber)
            .sourceAccount(sourceAccount)
            .build();
    HashIDPreimage hashIDPreimage =
        new HashIDPreimage.Builder()
            .discriminant(EnvelopeType.ENVELOPE_TYPE_OP_ID)
            .operationID(operationID)
            .build();
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    hashIDPreimage.encode(new XdrDataOutputStream(outputStream));
    Hash operationIDHash = new Hash(Util.hash(outputStream.toByteArray()));
    outputStream.reset();

    ClaimableBalanceID result = new ClaimableBalanceID();
    result.setDiscriminant(ClaimableBalanceIDType.CLAIMABLE_BALANCE_ID_TYPE_V0);
    result.setV0(operationIDHash);
    result.encode(new XdrDataOutputStream(outputStream));
    return Util.bytesToHex(outputStream.toByteArray()).toLowerCase();
  }

  /** Generates Transaction XDR object. */
  private TransactionV0 toXdr() {
    // fee
    Uint32 fee = new Uint32();
    fee.setUint32(new XdrUnsignedInteger(mFee));
    // sequenceNumber
    Int64 sequenceNumberUint = new Int64();
    sequenceNumberUint.setInt64(mSequenceNumber);
    SequenceNumber sequenceNumber = new SequenceNumber();
    sequenceNumber.setSequenceNumber(sequenceNumberUint);
    // operations
    org.stellar.sdk.xdr.Operation[] operations =
        new org.stellar.sdk.xdr.Operation[mOperations.length];
    for (int i = 0; i < mOperations.length; i++) {
      operations[i] = mOperations[i].toXdr(AccountConverter.enableMuxed());
    }
    // ext
    TransactionV0.TransactionV0Ext ext = new TransactionV0.TransactionV0Ext();
    ext.setDiscriminant(0);

    TransactionV0 transaction = new TransactionV0();
    transaction.setFee(fee);
    transaction.setSeqNum(sequenceNumber);
    transaction.setSourceAccountEd25519(
        StrKey.encodeToXDRAccountId(this.mSourceAccount).getAccountID().getEd25519());
    transaction.setOperations(operations);
    transaction.setMemo(mMemo.toXdr());
    transaction.setTimeBounds(getTimeBounds() == null ? null : getTimeBounds().toXdr());
    transaction.setExt(ext);
    return transaction;
  }

  private org.stellar.sdk.xdr.Transaction toV1Xdr(AccountConverter accountConverter) {

    // fee
    Uint32 fee = new Uint32();
    fee.setUint32((new XdrUnsignedInteger(mFee)));
    // sequenceNumber
    Int64 sequenceNumberUint = new Int64();
    sequenceNumberUint.setInt64(mSequenceNumber);
    SequenceNumber sequenceNumber = new SequenceNumber();
    sequenceNumber.setSequenceNumber(sequenceNumberUint);
    // operations
    org.stellar.sdk.xdr.Operation[] operations =
        new org.stellar.sdk.xdr.Operation[mOperations.length];
    for (int i = 0; i < mOperations.length; i++) {
      operations[i] = mOperations[i].toXdr(accountConverter);
    }
    // ext
    org.stellar.sdk.xdr.Transaction.TransactionExt ext =
        new org.stellar.sdk.xdr.Transaction.TransactionExt();
    if (this.mSorobanData != null) {
      ext.setDiscriminant(1);
      ext.setSorobanData(this.mSorobanData);
    } else {
      ext.setDiscriminant(0);
    }

    org.stellar.sdk.xdr.Transaction v1Tx = new org.stellar.sdk.xdr.Transaction();
    v1Tx.setFee(fee);
    v1Tx.setSeqNum(sequenceNumber);
    v1Tx.setSourceAccount(accountConverter.encode(mSourceAccount));
    v1Tx.setOperations(operations);
    v1Tx.setMemo(mMemo.toXdr());
    v1Tx.setCond(mPreconditions.toXdr());
    v1Tx.setExt(ext);

    return v1Tx;
  }

  public static Transaction fromV0EnvelopeXdr(
      AccountConverter accountConverter, TransactionV0Envelope envelope, Network network) {
    long mFee = envelope.getTx().getFee().getUint32().getNumber();
    Long mSequenceNumber = envelope.getTx().getSeqNum().getSequenceNumber().getInt64();
    Memo mMemo = Memo.fromXdr(envelope.getTx().getMemo());
    TimeBounds mTimeBounds = TimeBounds.fromXdr(envelope.getTx().getTimeBounds());

    Operation[] mOperations = new Operation[envelope.getTx().getOperations().length];
    for (int i = 0; i < envelope.getTx().getOperations().length; i++) {
      mOperations[i] = Operation.fromXdr(accountConverter, envelope.getTx().getOperations()[i]);
    }

    Transaction transaction =
        new Transaction(
            accountConverter,
            StrKey.encodeStellarAccountId(envelope.getTx().getSourceAccountEd25519().getUint256()),
            mFee,
            mSequenceNumber,
            mOperations,
            mMemo,
            TransactionPreconditions.builder().timeBounds(mTimeBounds).build(),
            null,
            network);
    transaction.setEnvelopeType(EnvelopeType.ENVELOPE_TYPE_TX_V0);

    transaction.mSignatures.addAll(Arrays.asList(envelope.getSignatures()));

    return transaction;
  }

  public static Transaction fromV0EnvelopeXdr(TransactionV0Envelope envelope, Network network) {
    return fromV0EnvelopeXdr(AccountConverter.enableMuxed(), envelope, network);
  }

  public static Transaction fromV1EnvelopeXdr(
      AccountConverter accountConverter, TransactionV1Envelope envelope, Network network) {
    long mFee = envelope.getTx().getFee().getUint32().getNumber();
    Long mSequenceNumber = envelope.getTx().getSeqNum().getSequenceNumber().getInt64();
    Memo mMemo = Memo.fromXdr(envelope.getTx().getMemo());

    Operation[] mOperations = new Operation[envelope.getTx().getOperations().length];
    for (int i = 0; i < envelope.getTx().getOperations().length; i++) {
      mOperations[i] = Operation.fromXdr(accountConverter, envelope.getTx().getOperations()[i]);
    }

    SorobanTransactionData sorobanData = envelope.getTx().getExt().getSorobanData();

    Transaction transaction =
        new Transaction(
            accountConverter,
            accountConverter.decode(envelope.getTx().getSourceAccount()),
            mFee,
            mSequenceNumber,
            mOperations,
            mMemo,
            TransactionPreconditions.fromXdr(envelope.getTx().getCond()),
            sorobanData,
            network);

    transaction.mSignatures.addAll(Arrays.asList(envelope.getSignatures()));

    return transaction;
  }

  public static Transaction fromV1EnvelopeXdr(TransactionV1Envelope envelope, Network network) {
    return fromV1EnvelopeXdr(AccountConverter.enableMuxed(), envelope, network);
  }

  /** Generates TransactionEnvelope XDR object. */
  @Override
  public TransactionEnvelope toEnvelopeXdr() {
    TransactionEnvelope xdr = new TransactionEnvelope();
    DecoratedSignature[] signatures = new DecoratedSignature[mSignatures.size()];
    signatures = mSignatures.toArray(signatures);

    if (this.envelopeType == EnvelopeType.ENVELOPE_TYPE_TX) {
      TransactionV1Envelope v1Envelope = new TransactionV1Envelope();
      xdr.setDiscriminant(EnvelopeType.ENVELOPE_TYPE_TX);
      v1Envelope.setTx(this.toV1Xdr(accountConverter));
      v1Envelope.setSignatures(signatures);
      xdr.setV1(v1Envelope);
    } else if (this.envelopeType == EnvelopeType.ENVELOPE_TYPE_TX_V0) {
      TransactionV0Envelope v0Envelope = new TransactionV0Envelope();
      xdr.setDiscriminant(EnvelopeType.ENVELOPE_TYPE_TX_V0);
      v0Envelope.setTx(this.toXdr());
      v0Envelope.setSignatures(signatures);
      xdr.setV0(v0Envelope);
    } else {
      throw new RuntimeException("invalid envelope type: " + this.envelopeType);
    }

    return xdr;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        this.envelopeType,
        this.mFee,
        this.mSourceAccount,
        this.mSequenceNumber,
        Arrays.hashCode(this.mOperations),
        this.mMemo,
        this.mPreconditions,
        this.mSignatures,
        this.mNetwork,
        this.mSorobanData);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof Transaction)) {
      return false;
    }

    Transaction other = (Transaction) object;
    return Objects.equals(this.envelopeType, other.envelopeType)
        && Objects.equals(this.mFee, other.mFee)
        && Objects.equals(this.mSourceAccount, other.mSourceAccount)
        && Objects.equals(this.mSequenceNumber, other.mSequenceNumber)
        && Arrays.equals(this.mOperations, other.mOperations)
        && Objects.equals(this.mMemo, other.mMemo)
        && Objects.equals(this.mPreconditions, other.mPreconditions)
        && Objects.equals(this.mNetwork, other.mNetwork)
        && Objects.equals(this.mSignatures, other.mSignatures)
        && Objects.equals(this.mSorobanData, other.mSorobanData);
  }

  /**
   * Maintain backwards compatibility references to Transaction.Builder
   *
   * @deprecated will be removed in upcoming releases. Use <code>TransactionBuilder</code> instead.
   * @see org.stellar.sdk.TransactionBuilder
   */
  public static class Builder extends TransactionBuilder {
    public Builder(
        AccountConverter accountConverter,
        TransactionBuilderAccount sourceAccount,
        Network network) {
      super(accountConverter, sourceAccount, network);
    }

    public Builder(TransactionBuilderAccount sourceAccount, Network network) {
      super(sourceAccount, network);
    }
  }

  /**
   * Returns true if this transaction is a Soroban transaction.
   *
   * @return true if this transaction is a Soroban transaction.
   */
  public boolean isSorobanTransaction() {
    if (mOperations.length != 1) {
      return false;
    }

    Operation op = mOperations[0];
    return op instanceof InvokeHostFunctionOperation
        || op instanceof BumpFootprintExpirationOperation
        || op instanceof RestoreFootprintOperation;
  }
}
