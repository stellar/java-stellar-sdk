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

//  union ClaimableBalanceID switch (ClaimableBalanceIDType type)
//  {
//  case CLAIMABLE_BALANCE_ID_TYPE_V0:
//      Hash v0;
//  };

//  ===========================================================================
public class ClaimableBalanceID implements XdrElement {
  public ClaimableBalanceID() {}

  ClaimableBalanceIDType type;

  public ClaimableBalanceIDType getDiscriminant() {
    return this.type;
  }

  public void setDiscriminant(ClaimableBalanceIDType value) {
    this.type = value;
  }

  private Hash v0;

  public Hash getV0() {
    return this.v0;
  }

  public void setV0(Hash value) {
    this.v0 = value;
  }

  public static final class Builder {
    private ClaimableBalanceIDType discriminant;
    private Hash v0;

    public Builder discriminant(ClaimableBalanceIDType discriminant) {
      this.discriminant = discriminant;
      return this;
    }

    public Builder v0(Hash v0) {
      this.v0 = v0;
      return this;
    }

    public ClaimableBalanceID build() {
      ClaimableBalanceID val = new ClaimableBalanceID();
      val.setDiscriminant(discriminant);
      val.setV0(this.v0);
      return val;
    }
  }

  public static void encode(
      XdrDataOutputStream stream, ClaimableBalanceID encodedClaimableBalanceID) throws IOException {
    // Xdrgen::AST::Identifier
    // ClaimableBalanceIDType
    stream.writeInt(encodedClaimableBalanceID.getDiscriminant().getValue());
    switch (encodedClaimableBalanceID.getDiscriminant()) {
      case CLAIMABLE_BALANCE_ID_TYPE_V0:
        Hash.encode(stream, encodedClaimableBalanceID.v0);
        break;
    }
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static ClaimableBalanceID decode(XdrDataInputStream stream) throws IOException {
    ClaimableBalanceID decodedClaimableBalanceID = new ClaimableBalanceID();
    ClaimableBalanceIDType discriminant = ClaimableBalanceIDType.decode(stream);
    decodedClaimableBalanceID.setDiscriminant(discriminant);
    switch (decodedClaimableBalanceID.getDiscriminant()) {
      case CLAIMABLE_BALANCE_ID_TYPE_V0:
        decodedClaimableBalanceID.v0 = Hash.decode(stream);
        break;
    }
    return decodedClaimableBalanceID;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.v0, this.type);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof ClaimableBalanceID)) {
      return false;
    }

    ClaimableBalanceID other = (ClaimableBalanceID) object;
    return Objects.equals(this.v0, other.v0) && Objects.equals(this.type, other.type);
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

  public static ClaimableBalanceID fromXdrBase64(String xdr) throws IOException {
    byte[] bytes = Base64Factory.getInstance().decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static ClaimableBalanceID fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }
}
