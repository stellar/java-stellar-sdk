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

//  struct ConfigUpgradeSetKey {
//      Hash contractID;
//      Hash contentHash;
//  };

//  ===========================================================================
public class ConfigUpgradeSetKey implements XdrElement {
  public ConfigUpgradeSetKey() {}

  private Hash contractID;

  public Hash getContractID() {
    return this.contractID;
  }

  public void setContractID(Hash value) {
    this.contractID = value;
  }

  private Hash contentHash;

  public Hash getContentHash() {
    return this.contentHash;
  }

  public void setContentHash(Hash value) {
    this.contentHash = value;
  }

  public static void encode(
      XdrDataOutputStream stream, ConfigUpgradeSetKey encodedConfigUpgradeSetKey)
      throws IOException {
    Hash.encode(stream, encodedConfigUpgradeSetKey.contractID);
    Hash.encode(stream, encodedConfigUpgradeSetKey.contentHash);
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static ConfigUpgradeSetKey decode(XdrDataInputStream stream) throws IOException {
    ConfigUpgradeSetKey decodedConfigUpgradeSetKey = new ConfigUpgradeSetKey();
    decodedConfigUpgradeSetKey.contractID = Hash.decode(stream);
    decodedConfigUpgradeSetKey.contentHash = Hash.decode(stream);
    return decodedConfigUpgradeSetKey;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(this.contractID, this.contentHash);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof ConfigUpgradeSetKey)) {
      return false;
    }

    ConfigUpgradeSetKey other = (ConfigUpgradeSetKey) object;
    return Objects.equal(this.contractID, other.contractID)
        && Objects.equal(this.contentHash, other.contentHash);
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

  public static ConfigUpgradeSetKey fromXdrBase64(String xdr) throws IOException {
    BaseEncoding base64Encoding = BaseEncoding.base64();
    byte[] bytes = base64Encoding.decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static ConfigUpgradeSetKey fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }

  public static final class Builder {
    private Hash contractID;
    private Hash contentHash;

    public Builder contractID(Hash contractID) {
      this.contractID = contractID;
      return this;
    }

    public Builder contentHash(Hash contentHash) {
      this.contentHash = contentHash;
      return this;
    }

    public ConfigUpgradeSetKey build() {
      ConfigUpgradeSetKey val = new ConfigUpgradeSetKey();
      val.setContractID(this.contractID);
      val.setContentHash(this.contentHash);
      return val;
    }
  }
}
