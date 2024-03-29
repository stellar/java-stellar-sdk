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

//  union GeneralizedTransactionSet switch (int v)
//  {
//  // We consider the legacy TransactionSet to be v0.
//  case 1:
//      TransactionSetV1 v1TxSet;
//  };

//  ===========================================================================
public class GeneralizedTransactionSet implements XdrElement {
  public GeneralizedTransactionSet() {}

  Integer v;

  public Integer getDiscriminant() {
    return this.v;
  }

  public void setDiscriminant(Integer value) {
    this.v = value;
  }

  private TransactionSetV1 v1TxSet;

  public TransactionSetV1 getV1TxSet() {
    return this.v1TxSet;
  }

  public void setV1TxSet(TransactionSetV1 value) {
    this.v1TxSet = value;
  }

  public static final class Builder {
    private Integer discriminant;
    private TransactionSetV1 v1TxSet;

    public Builder discriminant(Integer discriminant) {
      this.discriminant = discriminant;
      return this;
    }

    public Builder v1TxSet(TransactionSetV1 v1TxSet) {
      this.v1TxSet = v1TxSet;
      return this;
    }

    public GeneralizedTransactionSet build() {
      GeneralizedTransactionSet val = new GeneralizedTransactionSet();
      val.setDiscriminant(discriminant);
      val.setV1TxSet(this.v1TxSet);
      return val;
    }
  }

  public static void encode(
      XdrDataOutputStream stream, GeneralizedTransactionSet encodedGeneralizedTransactionSet)
      throws IOException {
    // Xdrgen::AST::Typespecs::Int
    // Integer
    stream.writeInt(encodedGeneralizedTransactionSet.getDiscriminant().intValue());
    switch (encodedGeneralizedTransactionSet.getDiscriminant()) {
      case 1:
        TransactionSetV1.encode(stream, encodedGeneralizedTransactionSet.v1TxSet);
        break;
    }
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static GeneralizedTransactionSet decode(XdrDataInputStream stream) throws IOException {
    GeneralizedTransactionSet decodedGeneralizedTransactionSet = new GeneralizedTransactionSet();
    Integer discriminant = stream.readInt();
    decodedGeneralizedTransactionSet.setDiscriminant(discriminant);
    switch (decodedGeneralizedTransactionSet.getDiscriminant()) {
      case 1:
        decodedGeneralizedTransactionSet.v1TxSet = TransactionSetV1.decode(stream);
        break;
    }
    return decodedGeneralizedTransactionSet;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.v1TxSet, this.v);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof GeneralizedTransactionSet)) {
      return false;
    }

    GeneralizedTransactionSet other = (GeneralizedTransactionSet) object;
    return Objects.equals(this.v1TxSet, other.v1TxSet) && Objects.equals(this.v, other.v);
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

  public static GeneralizedTransactionSet fromXdrBase64(String xdr) throws IOException {
    byte[] bytes = Base64Factory.getInstance().decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static GeneralizedTransactionSet fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }
}
