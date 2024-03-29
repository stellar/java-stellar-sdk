// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.stellar.sdk.xdr;

import static org.stellar.sdk.xdr.Constants.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.stellar.sdk.Base64Factory;

// === xdr source ============================================================

//  enum EnvelopeType
//  {
//      ENVELOPE_TYPE_TX_V0 = 0,
//      ENVELOPE_TYPE_SCP = 1,
//      ENVELOPE_TYPE_TX = 2,
//      ENVELOPE_TYPE_AUTH = 3,
//      ENVELOPE_TYPE_SCPVALUE = 4,
//      ENVELOPE_TYPE_TX_FEE_BUMP = 5,
//      ENVELOPE_TYPE_OP_ID = 6,
//      ENVELOPE_TYPE_POOL_REVOKE_OP_ID = 7,
//      ENVELOPE_TYPE_CONTRACT_ID = 8,
//      ENVELOPE_TYPE_SOROBAN_AUTHORIZATION = 9
//  };

//  ===========================================================================
public enum EnvelopeType implements XdrElement {
  ENVELOPE_TYPE_TX_V0(0),
  ENVELOPE_TYPE_SCP(1),
  ENVELOPE_TYPE_TX(2),
  ENVELOPE_TYPE_AUTH(3),
  ENVELOPE_TYPE_SCPVALUE(4),
  ENVELOPE_TYPE_TX_FEE_BUMP(5),
  ENVELOPE_TYPE_OP_ID(6),
  ENVELOPE_TYPE_POOL_REVOKE_OP_ID(7),
  ENVELOPE_TYPE_CONTRACT_ID(8),
  ENVELOPE_TYPE_SOROBAN_AUTHORIZATION(9),
  ;
  private int mValue;

  EnvelopeType(int value) {
    mValue = value;
  }

  public int getValue() {
    return mValue;
  }

  public static EnvelopeType decode(XdrDataInputStream stream) throws IOException {
    int value = stream.readInt();
    switch (value) {
      case 0:
        return ENVELOPE_TYPE_TX_V0;
      case 1:
        return ENVELOPE_TYPE_SCP;
      case 2:
        return ENVELOPE_TYPE_TX;
      case 3:
        return ENVELOPE_TYPE_AUTH;
      case 4:
        return ENVELOPE_TYPE_SCPVALUE;
      case 5:
        return ENVELOPE_TYPE_TX_FEE_BUMP;
      case 6:
        return ENVELOPE_TYPE_OP_ID;
      case 7:
        return ENVELOPE_TYPE_POOL_REVOKE_OP_ID;
      case 8:
        return ENVELOPE_TYPE_CONTRACT_ID;
      case 9:
        return ENVELOPE_TYPE_SOROBAN_AUTHORIZATION;
      default:
        throw new RuntimeException("Unknown enum value: " + value);
    }
  }

  public static void encode(XdrDataOutputStream stream, EnvelopeType value) throws IOException {
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

  public static EnvelopeType fromXdrBase64(String xdr) throws IOException {
    byte[] bytes = Base64Factory.getInstance().decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static EnvelopeType fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }
}
