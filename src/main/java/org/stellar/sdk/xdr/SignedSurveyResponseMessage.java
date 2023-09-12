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

//  struct SignedSurveyResponseMessage
//  {
//      Signature responseSignature;
//      SurveyResponseMessage response;
//  };

//  ===========================================================================
public class SignedSurveyResponseMessage implements XdrElement {
  public SignedSurveyResponseMessage() {}

  private Signature responseSignature;

  public Signature getResponseSignature() {
    return this.responseSignature;
  }

  public void setResponseSignature(Signature value) {
    this.responseSignature = value;
  }

  private SurveyResponseMessage response;

  public SurveyResponseMessage getResponse() {
    return this.response;
  }

  public void setResponse(SurveyResponseMessage value) {
    this.response = value;
  }

  public static void encode(
      XdrDataOutputStream stream, SignedSurveyResponseMessage encodedSignedSurveyResponseMessage)
      throws IOException {
    Signature.encode(stream, encodedSignedSurveyResponseMessage.responseSignature);
    SurveyResponseMessage.encode(stream, encodedSignedSurveyResponseMessage.response);
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static SignedSurveyResponseMessage decode(XdrDataInputStream stream) throws IOException {
    SignedSurveyResponseMessage decodedSignedSurveyResponseMessage =
        new SignedSurveyResponseMessage();
    decodedSignedSurveyResponseMessage.responseSignature = Signature.decode(stream);
    decodedSignedSurveyResponseMessage.response = SurveyResponseMessage.decode(stream);
    return decodedSignedSurveyResponseMessage;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(this.responseSignature, this.response);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof SignedSurveyResponseMessage)) {
      return false;
    }

    SignedSurveyResponseMessage other = (SignedSurveyResponseMessage) object;
    return Objects.equal(this.responseSignature, other.responseSignature)
        && Objects.equal(this.response, other.response);
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

  public static SignedSurveyResponseMessage fromXdrBase64(String xdr) throws IOException {
    BaseEncoding base64Encoding = BaseEncoding.base64();
    byte[] bytes = base64Encoding.decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static SignedSurveyResponseMessage fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }

  public static final class Builder {
    private Signature responseSignature;
    private SurveyResponseMessage response;

    public Builder responseSignature(Signature responseSignature) {
      this.responseSignature = responseSignature;
      return this;
    }

    public Builder response(SurveyResponseMessage response) {
      this.response = response;
      return this;
    }

    public SignedSurveyResponseMessage build() {
      SignedSurveyResponseMessage val = new SignedSurveyResponseMessage();
      val.setResponseSignature(this.responseSignature);
      val.setResponse(this.response);
      return val;
    }
  }
}
