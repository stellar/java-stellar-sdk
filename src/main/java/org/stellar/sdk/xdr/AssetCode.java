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

//  union AssetCode switch (AssetType type)
//  {
//  case ASSET_TYPE_CREDIT_ALPHANUM4:
//      AssetCode4 assetCode4;
//
//  case ASSET_TYPE_CREDIT_ALPHANUM12:
//      AssetCode12 assetCode12;
//
//      // add other asset types here in the future
//  };

//  ===========================================================================
public class AssetCode implements XdrElement {
  public AssetCode() {}

  AssetType type;

  public AssetType getDiscriminant() {
    return this.type;
  }

  public void setDiscriminant(AssetType value) {
    this.type = value;
  }

  private AssetCode4 assetCode4;

  public AssetCode4 getAssetCode4() {
    return this.assetCode4;
  }

  public void setAssetCode4(AssetCode4 value) {
    this.assetCode4 = value;
  }

  private AssetCode12 assetCode12;

  public AssetCode12 getAssetCode12() {
    return this.assetCode12;
  }

  public void setAssetCode12(AssetCode12 value) {
    this.assetCode12 = value;
  }

  public static final class Builder {
    private AssetType discriminant;
    private AssetCode4 assetCode4;
    private AssetCode12 assetCode12;

    public Builder discriminant(AssetType discriminant) {
      this.discriminant = discriminant;
      return this;
    }

    public Builder assetCode4(AssetCode4 assetCode4) {
      this.assetCode4 = assetCode4;
      return this;
    }

    public Builder assetCode12(AssetCode12 assetCode12) {
      this.assetCode12 = assetCode12;
      return this;
    }

    public AssetCode build() {
      AssetCode val = new AssetCode();
      val.setDiscriminant(discriminant);
      val.setAssetCode4(this.assetCode4);
      val.setAssetCode12(this.assetCode12);
      return val;
    }
  }

  public static void encode(XdrDataOutputStream stream, AssetCode encodedAssetCode)
      throws IOException {
    // Xdrgen::AST::Identifier
    // AssetType
    stream.writeInt(encodedAssetCode.getDiscriminant().getValue());
    switch (encodedAssetCode.getDiscriminant()) {
      case ASSET_TYPE_CREDIT_ALPHANUM4:
        AssetCode4.encode(stream, encodedAssetCode.assetCode4);
        break;
      case ASSET_TYPE_CREDIT_ALPHANUM12:
        AssetCode12.encode(stream, encodedAssetCode.assetCode12);
        break;
    }
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static AssetCode decode(XdrDataInputStream stream) throws IOException {
    AssetCode decodedAssetCode = new AssetCode();
    AssetType discriminant = AssetType.decode(stream);
    decodedAssetCode.setDiscriminant(discriminant);
    switch (decodedAssetCode.getDiscriminant()) {
      case ASSET_TYPE_CREDIT_ALPHANUM4:
        decodedAssetCode.assetCode4 = AssetCode4.decode(stream);
        break;
      case ASSET_TYPE_CREDIT_ALPHANUM12:
        decodedAssetCode.assetCode12 = AssetCode12.decode(stream);
        break;
    }
    return decodedAssetCode;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.assetCode4, this.assetCode12, this.type);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof AssetCode)) {
      return false;
    }

    AssetCode other = (AssetCode) object;
    return Objects.equals(this.assetCode4, other.assetCode4)
        && Objects.equals(this.assetCode12, other.assetCode12)
        && Objects.equals(this.type, other.type);
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

  public static AssetCode fromXdrBase64(String xdr) throws IOException {
    byte[] bytes = Base64Factory.getInstance().decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static AssetCode fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }
}
