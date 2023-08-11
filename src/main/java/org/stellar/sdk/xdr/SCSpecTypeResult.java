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

//  struct SCSpecTypeResult
//  {
//      SCSpecTypeDef okType;
//      SCSpecTypeDef errorType;
//  };

//  ===========================================================================
public class SCSpecTypeResult implements XdrElement {
  public SCSpecTypeResult() {}

  private SCSpecTypeDef okType;

  public SCSpecTypeDef getOkType() {
    return this.okType;
  }

  public void setOkType(SCSpecTypeDef value) {
    this.okType = value;
  }

  private SCSpecTypeDef errorType;

  public SCSpecTypeDef getErrorType() {
    return this.errorType;
  }

  public void setErrorType(SCSpecTypeDef value) {
    this.errorType = value;
  }

  public static void encode(XdrDataOutputStream stream, SCSpecTypeResult encodedSCSpecTypeResult)
      throws IOException {
    SCSpecTypeDef.encode(stream, encodedSCSpecTypeResult.okType);
    SCSpecTypeDef.encode(stream, encodedSCSpecTypeResult.errorType);
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static SCSpecTypeResult decode(XdrDataInputStream stream) throws IOException {
    SCSpecTypeResult decodedSCSpecTypeResult = new SCSpecTypeResult();
    decodedSCSpecTypeResult.okType = SCSpecTypeDef.decode(stream);
    decodedSCSpecTypeResult.errorType = SCSpecTypeDef.decode(stream);
    return decodedSCSpecTypeResult;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(this.okType, this.errorType);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof SCSpecTypeResult)) {
      return false;
    }

    SCSpecTypeResult other = (SCSpecTypeResult) object;
    return Objects.equal(this.okType, other.okType)
        && Objects.equal(this.errorType, other.errorType);
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

  public static SCSpecTypeResult fromXdrBase64(String xdr) throws IOException {
    BaseEncoding base64Encoding = BaseEncoding.base64();
    byte[] bytes = base64Encoding.decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static SCSpecTypeResult fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }

  public static final class Builder {
    private SCSpecTypeDef okType;
    private SCSpecTypeDef errorType;

    public Builder okType(SCSpecTypeDef okType) {
      this.okType = okType;
      return this;
    }

    public Builder errorType(SCSpecTypeDef errorType) {
      this.errorType = errorType;
      return this;
    }

    public SCSpecTypeResult build() {
      SCSpecTypeResult val = new SCSpecTypeResult();
      val.setOkType(this.okType);
      val.setErrorType(this.errorType);
      return val;
    }
  }
}