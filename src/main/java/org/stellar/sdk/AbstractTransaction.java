package org.stellar.sdk;

import com.google.common.io.BaseEncoding;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lombok.NonNull;
import org.stellar.sdk.xdr.DecoratedSignature;
import org.stellar.sdk.xdr.Hash;
import org.stellar.sdk.xdr.SignatureHint;
import org.stellar.sdk.xdr.TransactionEnvelope;
import org.stellar.sdk.xdr.TransactionSignaturePayload;

public abstract class AbstractTransaction {

  protected final Network mNetwork;
  protected final AccountConverter accountConverter;
  protected List<DecoratedSignature> mSignatures;
  public static final int MIN_BASE_FEE = 100;

  AbstractTransaction(@NonNull AccountConverter accountConverter, @NonNull Network network) {
    this.accountConverter = accountConverter;
    this.mNetwork = network;
    this.mSignatures = new ArrayList<DecoratedSignature>();
  }

  /**
   * Adds a new signature ed25519PublicKey to this transaction.
   *
   * @param signer {@link KeyPair} object representing a signer
   */
  public void sign(@NonNull KeyPair signer) {
    byte[] txHash = this.hash();
    mSignatures.add(signer.signDecorated(txHash));
  }

  /**
   * Adds a new sha256Hash signature to this transaction by revealing preimage.
   *
   * @param preimage the sha256 hash of preimage should be equal to signer hash
   */
  public void sign(byte @NonNull [] preimage) {
    org.stellar.sdk.xdr.Signature signature = new org.stellar.sdk.xdr.Signature();
    signature.setSignature(preimage);

    byte[] hash = Util.hash(preimage);
    byte[] signatureHintBytes = Arrays.copyOfRange(hash, hash.length - 4, hash.length);
    SignatureHint signatureHint = new SignatureHint();
    signatureHint.setSignatureHint(signatureHintBytes);

    DecoratedSignature decoratedSignature = new DecoratedSignature();
    decoratedSignature.setHint(signatureHint);
    decoratedSignature.setSignature(signature);

    mSignatures.add(decoratedSignature);
  }

  /** Returns transaction hash. */
  public byte[] hash() {
    return Util.hash(this.signatureBase());
  }

  /** Returns transaction hash encoded as a hexadecimal string. */
  public String hashHex() {
    return BaseEncoding.base16().lowerCase().encode(this.hash());
  }

  /** Returns signature base. */
  public abstract byte[] signatureBase();

  /**
   * Gets the Network string for this transaction.
   *
   * @return the Network string
   */
  public Network getNetwork() {
    return mNetwork;
  }

  /**
   * Gets the {@link AccountConverter} for this transaction.
   *
   * @return the {@link AccountConverter} object
   */
  public AccountConverter getAccountConverter() {
    return accountConverter;
  }

  /**
   * Gets read only list(immutable) of the signatures on transaction.
   *
   * @return immutable list of signatures
   */
  public List<DecoratedSignature> getSignatures() {
    return Collections.unmodifiableList(mSignatures);
  }

  /**
   * Adds an additional signature to the transaction's existing list of signatures.
   *
   * @param signature the signature to add
   */
  public void addSignature(DecoratedSignature signature) {
    mSignatures.add(signature);
  }

  public abstract TransactionEnvelope toEnvelopeXdr();

  /**
   * Returns base64-encoded TransactionEnvelope XDR object. Transaction need to have at least one
   * signature.
   */
  public String toEnvelopeXdrBase64() {
    try {
      return toEnvelopeXdr().toXdrBase64();
    } catch (IOException e) {
      throw new AssertionError(e);
    }
  }

  /**
   * Creates a <code>AbstractTransaction</code> instance from previously build <code>
   * TransactionEnvelope</code>
   *
   * @param envelope
   * @return
   */
  public static AbstractTransaction fromEnvelopeXdr(
      AccountConverter accountConverter, TransactionEnvelope envelope, Network network) {
    switch (envelope.getDiscriminant()) {
      case ENVELOPE_TYPE_TX:
        return Transaction.fromV1EnvelopeXdr(accountConverter, envelope.getV1(), network);
      case ENVELOPE_TYPE_TX_V0:
        return Transaction.fromV0EnvelopeXdr(accountConverter, envelope.getV0(), network);
      case ENVELOPE_TYPE_TX_FEE_BUMP:
        return FeeBumpTransaction.fromFeeBumpTransactionEnvelope(
            accountConverter, envelope.getFeeBump(), network);
      default:
        throw new IllegalArgumentException(
            "transaction type is not supported: " + envelope.getDiscriminant());
    }
  }

  /**
   * Creates a <code>AbstractTransaction</code> instance from previously build <code>
   * TransactionEnvelope</code>
   *
   * @param envelope
   * @return
   */
  public static AbstractTransaction fromEnvelopeXdr(TransactionEnvelope envelope, Network network) {
    return fromEnvelopeXdr(AccountConverter.enableMuxed(), envelope, network);
  }

  /**
   * Creates a <code>Transaction</code> instance from previously build <code>TransactionEnvelope
   * </code>
   *
   * @param envelope Base-64 encoded <code>TransactionEnvelope</code>
   * @return
   * @throws IOException
   */
  public static AbstractTransaction fromEnvelopeXdr(
      AccountConverter accountConverter, String envelope, Network network) throws IOException {
    TransactionEnvelope transactionEnvelope = TransactionEnvelope.fromXdrBase64(envelope);
    return fromEnvelopeXdr(accountConverter, transactionEnvelope, network);
  }

  /**
   * Creates a <code>Transaction</code> instance from previously build <code>TransactionEnvelope
   * </code>
   *
   * @param envelope Base-64 encoded <code>TransactionEnvelope</code>
   * @return
   * @throws IOException
   */
  public static AbstractTransaction fromEnvelopeXdr(String envelope, Network network)
      throws IOException {
    return fromEnvelopeXdr(AccountConverter.enableMuxed(), envelope, network);
  }

  public static byte[] getTransactionSignatureBase(
      TransactionSignaturePayload.TransactionSignaturePayloadTaggedTransaction taggedTransaction,
      Network network) {
    try {
      Hash networkIdHash = new Hash(network.getNetworkId());
      TransactionSignaturePayload payload =
          new TransactionSignaturePayload.Builder()
              .networkId(networkIdHash)
              .taggedTransaction(taggedTransaction)
              .build();
      return payload.toXdrByteArray();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
