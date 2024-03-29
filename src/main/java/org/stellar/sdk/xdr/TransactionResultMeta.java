// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.stellar.sdk.xdr;

import static org.stellar.sdk.xdr.Constants.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Objects;
import org.stellar.sdk.Base64Factory;

// === xdr source ============================================================

//  struct TransactionResultMeta
//  {
//      TransactionResultPair result;
//      LedgerEntryChanges feeProcessing;
//      TransactionMeta txApplyProcessing;
//  };

//  ===========================================================================
public class TransactionResultMeta implements XdrElement {
  public TransactionResultMeta() {}

  private TransactionResultPair result;

  public TransactionResultPair getResult() {
    return this.result;
  }

  public void setResult(TransactionResultPair value) {
    this.result = value;
  }

  private LedgerEntryChanges feeProcessing;

  public LedgerEntryChanges getFeeProcessing() {
    return this.feeProcessing;
  }

  public void setFeeProcessing(LedgerEntryChanges value) {
    this.feeProcessing = value;
  }

  private TransactionMeta txApplyProcessing;

  public TransactionMeta getTxApplyProcessing() {
    return this.txApplyProcessing;
  }

  public void setTxApplyProcessing(TransactionMeta value) {
    this.txApplyProcessing = value;
  }

  public static void encode(
      XdrDataOutputStream stream, TransactionResultMeta encodedTransactionResultMeta)
      throws IOException {
    TransactionResultPair.encode(stream, encodedTransactionResultMeta.result);
    LedgerEntryChanges.encode(stream, encodedTransactionResultMeta.feeProcessing);
    TransactionMeta.encode(stream, encodedTransactionResultMeta.txApplyProcessing);
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static TransactionResultMeta decode(XdrDataInputStream stream) throws IOException {
    TransactionResultMeta decodedTransactionResultMeta = new TransactionResultMeta();
    decodedTransactionResultMeta.result = TransactionResultPair.decode(stream);
    decodedTransactionResultMeta.feeProcessing = LedgerEntryChanges.decode(stream);
    decodedTransactionResultMeta.txApplyProcessing = TransactionMeta.decode(stream);
    return decodedTransactionResultMeta;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.result, this.feeProcessing, this.txApplyProcessing);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof TransactionResultMeta)) {
      return false;
    }

    TransactionResultMeta other = (TransactionResultMeta) object;
    return Objects.equals(this.result, other.result)
        && Objects.equals(this.feeProcessing, other.feeProcessing)
        && Objects.equals(this.txApplyProcessing, other.txApplyProcessing);
  }

  @Override
  public String toXdrBase64() throws IOException {
    return Base64Factory.getInstance().encodeToString(toXdrByteArray());
  }

  @Override
  public byte[] toXdrByteArray() throws IOException {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    XdrDataOutputStream xdrDataOutputStream = new XdrDataOutputStream(byteArrayOutputStream);
    encode(xdrDataOutputStream);
    return byteArrayOutputStream.toByteArray();
  }

  public static TransactionResultMeta fromXdrBase64(String xdr) throws IOException {
    byte[] bytes = Base64Factory.getInstance().decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static TransactionResultMeta fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }

  public static final class Builder {
    private TransactionResultPair result;
    private LedgerEntryChanges feeProcessing;
    private TransactionMeta txApplyProcessing;

    public Builder result(TransactionResultPair result) {
      this.result = result;
      return this;
    }

    public Builder feeProcessing(LedgerEntryChanges feeProcessing) {
      this.feeProcessing = feeProcessing;
      return this;
    }

    public Builder txApplyProcessing(TransactionMeta txApplyProcessing) {
      this.txApplyProcessing = txApplyProcessing;
      return this;
    }

    public TransactionResultMeta build() {
      TransactionResultMeta val = new TransactionResultMeta();
      val.setResult(this.result);
      val.setFeeProcessing(this.feeProcessing);
      val.setTxApplyProcessing(this.txApplyProcessing);
      return val;
    }
  }
}
