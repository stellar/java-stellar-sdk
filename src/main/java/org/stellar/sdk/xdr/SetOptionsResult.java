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

//  union SetOptionsResult switch (SetOptionsResultCode code)
//  {
//  case SET_OPTIONS_SUCCESS:
//      void;
//  case SET_OPTIONS_LOW_RESERVE:
//  case SET_OPTIONS_TOO_MANY_SIGNERS:
//  case SET_OPTIONS_BAD_FLAGS:
//  case SET_OPTIONS_INVALID_INFLATION:
//  case SET_OPTIONS_CANT_CHANGE:
//  case SET_OPTIONS_UNKNOWN_FLAG:
//  case SET_OPTIONS_THRESHOLD_OUT_OF_RANGE:
//  case SET_OPTIONS_BAD_SIGNER:
//  case SET_OPTIONS_INVALID_HOME_DOMAIN:
//  case SET_OPTIONS_AUTH_REVOCABLE_REQUIRED:
//      void;
//  };

//  ===========================================================================
public class SetOptionsResult implements XdrElement {
  public SetOptionsResult() {}

  SetOptionsResultCode code;

  public SetOptionsResultCode getDiscriminant() {
    return this.code;
  }

  public void setDiscriminant(SetOptionsResultCode value) {
    this.code = value;
  }

  public static final class Builder {
    private SetOptionsResultCode discriminant;

    public Builder discriminant(SetOptionsResultCode discriminant) {
      this.discriminant = discriminant;
      return this;
    }

    public SetOptionsResult build() {
      SetOptionsResult val = new SetOptionsResult();
      val.setDiscriminant(discriminant);
      return val;
    }
  }

  public static void encode(XdrDataOutputStream stream, SetOptionsResult encodedSetOptionsResult)
      throws IOException {
    // Xdrgen::AST::Identifier
    // SetOptionsResultCode
    stream.writeInt(encodedSetOptionsResult.getDiscriminant().getValue());
    switch (encodedSetOptionsResult.getDiscriminant()) {
      case SET_OPTIONS_SUCCESS:
        break;
      case SET_OPTIONS_LOW_RESERVE:
      case SET_OPTIONS_TOO_MANY_SIGNERS:
      case SET_OPTIONS_BAD_FLAGS:
      case SET_OPTIONS_INVALID_INFLATION:
      case SET_OPTIONS_CANT_CHANGE:
      case SET_OPTIONS_UNKNOWN_FLAG:
      case SET_OPTIONS_THRESHOLD_OUT_OF_RANGE:
      case SET_OPTIONS_BAD_SIGNER:
      case SET_OPTIONS_INVALID_HOME_DOMAIN:
      case SET_OPTIONS_AUTH_REVOCABLE_REQUIRED:
        break;
    }
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static SetOptionsResult decode(XdrDataInputStream stream) throws IOException {
    SetOptionsResult decodedSetOptionsResult = new SetOptionsResult();
    SetOptionsResultCode discriminant = SetOptionsResultCode.decode(stream);
    decodedSetOptionsResult.setDiscriminant(discriminant);
    switch (decodedSetOptionsResult.getDiscriminant()) {
      case SET_OPTIONS_SUCCESS:
        break;
      case SET_OPTIONS_LOW_RESERVE:
      case SET_OPTIONS_TOO_MANY_SIGNERS:
      case SET_OPTIONS_BAD_FLAGS:
      case SET_OPTIONS_INVALID_INFLATION:
      case SET_OPTIONS_CANT_CHANGE:
      case SET_OPTIONS_UNKNOWN_FLAG:
      case SET_OPTIONS_THRESHOLD_OUT_OF_RANGE:
      case SET_OPTIONS_BAD_SIGNER:
      case SET_OPTIONS_INVALID_HOME_DOMAIN:
      case SET_OPTIONS_AUTH_REVOCABLE_REQUIRED:
        break;
    }
    return decodedSetOptionsResult;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.code);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof SetOptionsResult)) {
      return false;
    }

    SetOptionsResult other = (SetOptionsResult) object;
    return Objects.equals(this.code, other.code);
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

  public static SetOptionsResult fromXdrBase64(String xdr) throws IOException {
    byte[] bytes = Base64Factory.getInstance().decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static SetOptionsResult fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }
}
