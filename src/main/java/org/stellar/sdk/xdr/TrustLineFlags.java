// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.stellar.sdk.xdr;

import static org.stellar.sdk.xdr.Constants.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.stellar.sdk.Base64Factory;

// === xdr source ============================================================

//  enum TrustLineFlags
//  {
//      // issuer has authorized account to perform transactions with its credit
//      AUTHORIZED_FLAG = 1,
//      // issuer has authorized account to maintain and reduce liabilities for its
//      // credit
//      AUTHORIZED_TO_MAINTAIN_LIABILITIES_FLAG = 2,
//      // issuer has specified that it may clawback its credit, and that claimable
//      // balances created with its credit may also be clawed back
//      TRUSTLINE_CLAWBACK_ENABLED_FLAG = 4
//  };

//  ===========================================================================
public enum TrustLineFlags implements XdrElement {
  AUTHORIZED_FLAG(1),
  AUTHORIZED_TO_MAINTAIN_LIABILITIES_FLAG(2),
  TRUSTLINE_CLAWBACK_ENABLED_FLAG(4),
  ;
  private int mValue;

  TrustLineFlags(int value) {
    mValue = value;
  }

  public int getValue() {
    return mValue;
  }

  public static TrustLineFlags decode(XdrDataInputStream stream) throws IOException {
    int value = stream.readInt();
    switch (value) {
      case 1:
        return AUTHORIZED_FLAG;
      case 2:
        return AUTHORIZED_TO_MAINTAIN_LIABILITIES_FLAG;
      case 4:
        return TRUSTLINE_CLAWBACK_ENABLED_FLAG;
      default:
        throw new RuntimeException("Unknown enum value: " + value);
    }
  }

  public static void encode(XdrDataOutputStream stream, TrustLineFlags value) throws IOException {
    stream.writeInt(value.getValue());
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
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

  public static TrustLineFlags fromXdrBase64(String xdr) throws IOException {
    byte[] bytes = Base64Factory.getInstance().decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static TrustLineFlags fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }
}
