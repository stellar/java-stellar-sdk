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

//  struct InnerTransactionResultPair
//  {
//      Hash transactionHash;          // hash of the inner transaction
//      InnerTransactionResult result; // result for the inner transaction
//  };

//  ===========================================================================
public class InnerTransactionResultPair implements XdrElement {
  public InnerTransactionResultPair() {}

  private Hash transactionHash;

  public Hash getTransactionHash() {
    return this.transactionHash;
  }

  public void setTransactionHash(Hash value) {
    this.transactionHash = value;
  }

  private InnerTransactionResult result;

  public InnerTransactionResult getResult() {
    return this.result;
  }

  public void setResult(InnerTransactionResult value) {
    this.result = value;
  }

  public static void encode(
      XdrDataOutputStream stream, InnerTransactionResultPair encodedInnerTransactionResultPair)
      throws IOException {
    Hash.encode(stream, encodedInnerTransactionResultPair.transactionHash);
    InnerTransactionResult.encode(stream, encodedInnerTransactionResultPair.result);
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static InnerTransactionResultPair decode(XdrDataInputStream stream) throws IOException {
    InnerTransactionResultPair decodedInnerTransactionResultPair = new InnerTransactionResultPair();
    decodedInnerTransactionResultPair.transactionHash = Hash.decode(stream);
    decodedInnerTransactionResultPair.result = InnerTransactionResult.decode(stream);
    return decodedInnerTransactionResultPair;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.transactionHash, this.result);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof InnerTransactionResultPair)) {
      return false;
    }

    InnerTransactionResultPair other = (InnerTransactionResultPair) object;
    return Objects.equals(this.transactionHash, other.transactionHash)
        && Objects.equals(this.result, other.result);
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

  public static InnerTransactionResultPair fromXdrBase64(String xdr) throws IOException {
    byte[] bytes = Base64Factory.getInstance().decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static InnerTransactionResultPair fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }

  public static final class Builder {
    private Hash transactionHash;
    private InnerTransactionResult result;

    public Builder transactionHash(Hash transactionHash) {
      this.transactionHash = transactionHash;
      return this;
    }

    public Builder result(InnerTransactionResult result) {
      this.result = result;
      return this;
    }

    public InnerTransactionResultPair build() {
      InnerTransactionResultPair val = new InnerTransactionResultPair();
      val.setTransactionHash(this.transactionHash);
      val.setResult(this.result);
      return val;
    }
  }
}
