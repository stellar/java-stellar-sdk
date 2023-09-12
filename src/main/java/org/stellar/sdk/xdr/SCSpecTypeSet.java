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

//  struct SCSpecTypeSet
//  {
//      SCSpecTypeDef elementType;
//  };

//  ===========================================================================
public class SCSpecTypeSet implements XdrElement {
  public SCSpecTypeSet() {}

  private SCSpecTypeDef elementType;

  public SCSpecTypeDef getElementType() {
    return this.elementType;
  }

  public void setElementType(SCSpecTypeDef value) {
    this.elementType = value;
  }

  public static void encode(XdrDataOutputStream stream, SCSpecTypeSet encodedSCSpecTypeSet)
      throws IOException {
    SCSpecTypeDef.encode(stream, encodedSCSpecTypeSet.elementType);
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static SCSpecTypeSet decode(XdrDataInputStream stream) throws IOException {
    SCSpecTypeSet decodedSCSpecTypeSet = new SCSpecTypeSet();
    decodedSCSpecTypeSet.elementType = SCSpecTypeDef.decode(stream);
    return decodedSCSpecTypeSet;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(this.elementType);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof SCSpecTypeSet)) {
      return false;
    }

    SCSpecTypeSet other = (SCSpecTypeSet) object;
    return Objects.equal(this.elementType, other.elementType);
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

  public static SCSpecTypeSet fromXdrBase64(String xdr) throws IOException {
    BaseEncoding base64Encoding = BaseEncoding.base64();
    byte[] bytes = base64Encoding.decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static SCSpecTypeSet fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }

  public static final class Builder {
    private SCSpecTypeDef elementType;

    public Builder elementType(SCSpecTypeDef elementType) {
      this.elementType = elementType;
      return this;
    }

    public SCSpecTypeSet build() {
      SCSpecTypeSet val = new SCSpecTypeSet();
      val.setElementType(this.elementType);
      return val;
    }
  }
}