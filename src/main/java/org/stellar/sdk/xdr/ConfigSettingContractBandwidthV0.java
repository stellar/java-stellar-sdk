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

//  struct ConfigSettingContractBandwidthV0
//  {
//      // Maximum sum of all transaction sizes in the ledger in bytes
//      uint32 ledgerMaxTxsSizeBytes;
//      // Maximum size in bytes for a transaction
//      uint32 txMaxSizeBytes;
//
//      // Fee for 1 KB of transaction size
//      int64 feeTxSize1KB;
//  };

//  ===========================================================================
public class ConfigSettingContractBandwidthV0 implements XdrElement {
  public ConfigSettingContractBandwidthV0() {}

  private Uint32 ledgerMaxTxsSizeBytes;

  public Uint32 getLedgerMaxTxsSizeBytes() {
    return this.ledgerMaxTxsSizeBytes;
  }

  public void setLedgerMaxTxsSizeBytes(Uint32 value) {
    this.ledgerMaxTxsSizeBytes = value;
  }

  private Uint32 txMaxSizeBytes;

  public Uint32 getTxMaxSizeBytes() {
    return this.txMaxSizeBytes;
  }

  public void setTxMaxSizeBytes(Uint32 value) {
    this.txMaxSizeBytes = value;
  }

  private Int64 feeTxSize1KB;

  public Int64 getFeeTxSize1KB() {
    return this.feeTxSize1KB;
  }

  public void setFeeTxSize1KB(Int64 value) {
    this.feeTxSize1KB = value;
  }

  public static void encode(
      XdrDataOutputStream stream,
      ConfigSettingContractBandwidthV0 encodedConfigSettingContractBandwidthV0)
      throws IOException {
    Uint32.encode(stream, encodedConfigSettingContractBandwidthV0.ledgerMaxTxsSizeBytes);
    Uint32.encode(stream, encodedConfigSettingContractBandwidthV0.txMaxSizeBytes);
    Int64.encode(stream, encodedConfigSettingContractBandwidthV0.feeTxSize1KB);
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static ConfigSettingContractBandwidthV0 decode(XdrDataInputStream stream)
      throws IOException {
    ConfigSettingContractBandwidthV0 decodedConfigSettingContractBandwidthV0 =
        new ConfigSettingContractBandwidthV0();
    decodedConfigSettingContractBandwidthV0.ledgerMaxTxsSizeBytes = Uint32.decode(stream);
    decodedConfigSettingContractBandwidthV0.txMaxSizeBytes = Uint32.decode(stream);
    decodedConfigSettingContractBandwidthV0.feeTxSize1KB = Int64.decode(stream);
    return decodedConfigSettingContractBandwidthV0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.ledgerMaxTxsSizeBytes, this.txMaxSizeBytes, this.feeTxSize1KB);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof ConfigSettingContractBandwidthV0)) {
      return false;
    }

    ConfigSettingContractBandwidthV0 other = (ConfigSettingContractBandwidthV0) object;
    return Objects.equals(this.ledgerMaxTxsSizeBytes, other.ledgerMaxTxsSizeBytes)
        && Objects.equals(this.txMaxSizeBytes, other.txMaxSizeBytes)
        && Objects.equals(this.feeTxSize1KB, other.feeTxSize1KB);
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

  public static ConfigSettingContractBandwidthV0 fromXdrBase64(String xdr) throws IOException {
    byte[] bytes = Base64Factory.getInstance().decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static ConfigSettingContractBandwidthV0 fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }

  public static final class Builder {
    private Uint32 ledgerMaxTxsSizeBytes;
    private Uint32 txMaxSizeBytes;
    private Int64 feeTxSize1KB;

    public Builder ledgerMaxTxsSizeBytes(Uint32 ledgerMaxTxsSizeBytes) {
      this.ledgerMaxTxsSizeBytes = ledgerMaxTxsSizeBytes;
      return this;
    }

    public Builder txMaxSizeBytes(Uint32 txMaxSizeBytes) {
      this.txMaxSizeBytes = txMaxSizeBytes;
      return this;
    }

    public Builder feeTxSize1KB(Int64 feeTxSize1KB) {
      this.feeTxSize1KB = feeTxSize1KB;
      return this;
    }

    public ConfigSettingContractBandwidthV0 build() {
      ConfigSettingContractBandwidthV0 val = new ConfigSettingContractBandwidthV0();
      val.setLedgerMaxTxsSizeBytes(this.ledgerMaxTxsSizeBytes);
      val.setTxMaxSizeBytes(this.txMaxSizeBytes);
      val.setFeeTxSize1KB(this.feeTxSize1KB);
      return val;
    }
  }
}
