// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.stellar.sdk.xdr;

import static org.stellar.sdk.xdr.Constants.*;

import com.google.common.base.Objects;
import com.google.common.io.BaseEncoding;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

// === xdr source ============================================================

//  struct SCSpecTypeUDT
//  {
//      string name<60>;
//  };

//  ===========================================================================
public class SCSpecTypeUDT implements XdrElement {
  public SCSpecTypeUDT() {}

  private XdrString name;

  public XdrString getName() {
    return this.name;
  }

  public void setName(XdrString value) {
    this.name = value;
  }

  public static void encode(XdrDataOutputStream stream, SCSpecTypeUDT encodedSCSpecTypeUDT)
      throws IOException {
    encodedSCSpecTypeUDT.name.encode(stream);
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static SCSpecTypeUDT decode(XdrDataInputStream stream) throws IOException {
    SCSpecTypeUDT decodedSCSpecTypeUDT = new SCSpecTypeUDT();
    decodedSCSpecTypeUDT.name = XdrString.decode(stream, 60);
    return decodedSCSpecTypeUDT;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(this.name);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof SCSpecTypeUDT)) {
      return false;
    }

    SCSpecTypeUDT other = (SCSpecTypeUDT) object;
    return Objects.equal(this.name, other.name);
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

  public static SCSpecTypeUDT fromXdrBase64(String xdr) throws IOException {
    BaseEncoding base64Encoding = BaseEncoding.base64();
    byte[] bytes = base64Encoding.decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static SCSpecTypeUDT fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }

  public static final class Builder {
    private XdrString name;

    public Builder name(XdrString name) {
      this.name = name;
      return this;
    }

    public SCSpecTypeUDT build() {
      SCSpecTypeUDT val = new SCSpecTypeUDT();
      val.setName(this.name);
      return val;
    }
  }
}
