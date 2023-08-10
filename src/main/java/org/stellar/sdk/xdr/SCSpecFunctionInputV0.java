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

//  struct SCSpecFunctionInputV0
//  {
//      string doc<SC_SPEC_DOC_LIMIT>;
//      string name<30>;
//      SCSpecTypeDef type;
//  };

//  ===========================================================================
public class SCSpecFunctionInputV0 implements XdrElement {
  public SCSpecFunctionInputV0() {}

  private XdrString doc;

  public XdrString getDoc() {
    return this.doc;
  }

  public void setDoc(XdrString value) {
    this.doc = value;
  }

  private XdrString name;

  public XdrString getName() {
    return this.name;
  }

  public void setName(XdrString value) {
    this.name = value;
  }

  private SCSpecTypeDef type;

  public SCSpecTypeDef getType() {
    return this.type;
  }

  public void setType(SCSpecTypeDef value) {
    this.type = value;
  }

  public static void encode(
      XdrDataOutputStream stream, SCSpecFunctionInputV0 encodedSCSpecFunctionInputV0)
      throws IOException {
    encodedSCSpecFunctionInputV0.doc.encode(stream);
    encodedSCSpecFunctionInputV0.name.encode(stream);
    SCSpecTypeDef.encode(stream, encodedSCSpecFunctionInputV0.type);
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static SCSpecFunctionInputV0 decode(XdrDataInputStream stream) throws IOException {
    SCSpecFunctionInputV0 decodedSCSpecFunctionInputV0 = new SCSpecFunctionInputV0();
    decodedSCSpecFunctionInputV0.doc = XdrString.decode(stream, SC_SPEC_DOC_LIMIT);
    decodedSCSpecFunctionInputV0.name = XdrString.decode(stream, 30);
    decodedSCSpecFunctionInputV0.type = SCSpecTypeDef.decode(stream);
    return decodedSCSpecFunctionInputV0;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(this.doc, this.name, this.type);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof SCSpecFunctionInputV0)) {
      return false;
    }

    SCSpecFunctionInputV0 other = (SCSpecFunctionInputV0) object;
    return Objects.equal(this.doc, other.doc)
        && Objects.equal(this.name, other.name)
        && Objects.equal(this.type, other.type);
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

  public static SCSpecFunctionInputV0 fromXdrBase64(String xdr) throws IOException {
    BaseEncoding base64Encoding = BaseEncoding.base64();
    byte[] bytes = base64Encoding.decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static SCSpecFunctionInputV0 fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }

  public static final class Builder {
    private XdrString doc;
    private XdrString name;
    private SCSpecTypeDef type;

    public Builder doc(XdrString doc) {
      this.doc = doc;
      return this;
    }

    public Builder name(XdrString name) {
      this.name = name;
      return this;
    }

    public Builder type(SCSpecTypeDef type) {
      this.type = type;
      return this;
    }

    public SCSpecFunctionInputV0 build() {
      SCSpecFunctionInputV0 val = new SCSpecFunctionInputV0();
      val.setDoc(this.doc);
      val.setName(this.name);
      val.setType(this.type);
      return val;
    }
  }
}
