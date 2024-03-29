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

//  struct SCSpecTypeVec
//  {
//      SCSpecTypeDef elementType;
//  };

//  ===========================================================================
public class SCSpecTypeVec implements XdrElement {
  public SCSpecTypeVec() {}

  private SCSpecTypeDef elementType;

  public SCSpecTypeDef getElementType() {
    return this.elementType;
  }

  public void setElementType(SCSpecTypeDef value) {
    this.elementType = value;
  }

  public static void encode(XdrDataOutputStream stream, SCSpecTypeVec encodedSCSpecTypeVec)
      throws IOException {
    SCSpecTypeDef.encode(stream, encodedSCSpecTypeVec.elementType);
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static SCSpecTypeVec decode(XdrDataInputStream stream) throws IOException {
    SCSpecTypeVec decodedSCSpecTypeVec = new SCSpecTypeVec();
    decodedSCSpecTypeVec.elementType = SCSpecTypeDef.decode(stream);
    return decodedSCSpecTypeVec;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.elementType);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof SCSpecTypeVec)) {
      return false;
    }

    SCSpecTypeVec other = (SCSpecTypeVec) object;
    return Objects.equals(this.elementType, other.elementType);
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

  public static SCSpecTypeVec fromXdrBase64(String xdr) throws IOException {
    byte[] bytes = Base64Factory.getInstance().decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static SCSpecTypeVec fromXdrByteArray(byte[] xdr) throws IOException {
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

    public SCSpecTypeVec build() {
      SCSpecTypeVec val = new SCSpecTypeVec();
      val.setElementType(this.elementType);
      return val;
    }
  }
}
