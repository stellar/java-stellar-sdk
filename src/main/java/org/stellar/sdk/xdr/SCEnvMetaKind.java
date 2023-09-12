// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.stellar.sdk.xdr;

import static org.stellar.sdk.xdr.Constants.*;

import com.google.common.io.BaseEncoding;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

// === xdr source ============================================================

//  enum SCEnvMetaKind
//  {
//      SC_ENV_META_KIND_INTERFACE_VERSION = 0
//  };

//  ===========================================================================
public enum SCEnvMetaKind implements XdrElement {
  SC_ENV_META_KIND_INTERFACE_VERSION(0),
  ;
  private int mValue;

  SCEnvMetaKind(int value) {
    mValue = value;
  }

  public int getValue() {
    return mValue;
  }

  public static SCEnvMetaKind decode(XdrDataInputStream stream) throws IOException {
    int value = stream.readInt();
    switch (value) {
      case 0:
        return SC_ENV_META_KIND_INTERFACE_VERSION;
      default:
        throw new RuntimeException("Unknown enum value: " + value);
    }
  }

  public static void encode(XdrDataOutputStream stream, SCEnvMetaKind value) throws IOException {
    stream.writeInt(value.getValue());
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  @Override
  public String toXdrBase64() throws IOException {
    BaseEncoding base64Encoding = BaseEncoding.base64();
    return base64Encoding.encode(toXdrByteArray());
  }

  @Override
  public byte[] toXdrByteArray() throws IOException {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    XdrDataOutputStream xdrDataOutputStream = new XdrDataOutputStream(byteArrayOutputStream);
    encode(xdrDataOutputStream);
    return byteArrayOutputStream.toByteArray();
  }

  public static SCEnvMetaKind fromXdrBase64(String xdr) throws IOException {
    BaseEncoding base64Encoding = BaseEncoding.base64();
    byte[] bytes = base64Encoding.decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static SCEnvMetaKind fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }
}
