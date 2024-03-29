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

//  struct ConfigSettingContractComputeV0
//  {
//      // Maximum instructions per ledger
//      int64 ledgerMaxInstructions;
//      // Maximum instructions per transaction
//      int64 txMaxInstructions;
//      // Cost of 10000 instructions
//      int64 feeRatePerInstructionsIncrement;
//
//      // Memory limit per transaction. Unlike instructions, there is no fee
//      // for memory, just the limit.
//      uint32 txMemoryLimit;
//  };

//  ===========================================================================
public class ConfigSettingContractComputeV0 implements XdrElement {
  public ConfigSettingContractComputeV0() {}

  private Int64 ledgerMaxInstructions;

  public Int64 getLedgerMaxInstructions() {
    return this.ledgerMaxInstructions;
  }

  public void setLedgerMaxInstructions(Int64 value) {
    this.ledgerMaxInstructions = value;
  }

  private Int64 txMaxInstructions;

  public Int64 getTxMaxInstructions() {
    return this.txMaxInstructions;
  }

  public void setTxMaxInstructions(Int64 value) {
    this.txMaxInstructions = value;
  }

  private Int64 feeRatePerInstructionsIncrement;

  public Int64 getFeeRatePerInstructionsIncrement() {
    return this.feeRatePerInstructionsIncrement;
  }

  public void setFeeRatePerInstructionsIncrement(Int64 value) {
    this.feeRatePerInstructionsIncrement = value;
  }

  private Uint32 txMemoryLimit;

  public Uint32 getTxMemoryLimit() {
    return this.txMemoryLimit;
  }

  public void setTxMemoryLimit(Uint32 value) {
    this.txMemoryLimit = value;
  }

  public static void encode(
      XdrDataOutputStream stream,
      ConfigSettingContractComputeV0 encodedConfigSettingContractComputeV0)
      throws IOException {
    Int64.encode(stream, encodedConfigSettingContractComputeV0.ledgerMaxInstructions);
    Int64.encode(stream, encodedConfigSettingContractComputeV0.txMaxInstructions);
    Int64.encode(stream, encodedConfigSettingContractComputeV0.feeRatePerInstructionsIncrement);
    Uint32.encode(stream, encodedConfigSettingContractComputeV0.txMemoryLimit);
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static ConfigSettingContractComputeV0 decode(XdrDataInputStream stream)
      throws IOException {
    ConfigSettingContractComputeV0 decodedConfigSettingContractComputeV0 =
        new ConfigSettingContractComputeV0();
    decodedConfigSettingContractComputeV0.ledgerMaxInstructions = Int64.decode(stream);
    decodedConfigSettingContractComputeV0.txMaxInstructions = Int64.decode(stream);
    decodedConfigSettingContractComputeV0.feeRatePerInstructionsIncrement = Int64.decode(stream);
    decodedConfigSettingContractComputeV0.txMemoryLimit = Uint32.decode(stream);
    return decodedConfigSettingContractComputeV0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        this.ledgerMaxInstructions,
        this.txMaxInstructions,
        this.feeRatePerInstructionsIncrement,
        this.txMemoryLimit);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof ConfigSettingContractComputeV0)) {
      return false;
    }

    ConfigSettingContractComputeV0 other = (ConfigSettingContractComputeV0) object;
    return Objects.equals(this.ledgerMaxInstructions, other.ledgerMaxInstructions)
        && Objects.equals(this.txMaxInstructions, other.txMaxInstructions)
        && Objects.equals(
            this.feeRatePerInstructionsIncrement, other.feeRatePerInstructionsIncrement)
        && Objects.equals(this.txMemoryLimit, other.txMemoryLimit);
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

  public static ConfigSettingContractComputeV0 fromXdrBase64(String xdr) throws IOException {
    byte[] bytes = Base64Factory.getInstance().decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static ConfigSettingContractComputeV0 fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }

  public static final class Builder {
    private Int64 ledgerMaxInstructions;
    private Int64 txMaxInstructions;
    private Int64 feeRatePerInstructionsIncrement;
    private Uint32 txMemoryLimit;

    public Builder ledgerMaxInstructions(Int64 ledgerMaxInstructions) {
      this.ledgerMaxInstructions = ledgerMaxInstructions;
      return this;
    }

    public Builder txMaxInstructions(Int64 txMaxInstructions) {
      this.txMaxInstructions = txMaxInstructions;
      return this;
    }

    public Builder feeRatePerInstructionsIncrement(Int64 feeRatePerInstructionsIncrement) {
      this.feeRatePerInstructionsIncrement = feeRatePerInstructionsIncrement;
      return this;
    }

    public Builder txMemoryLimit(Uint32 txMemoryLimit) {
      this.txMemoryLimit = txMemoryLimit;
      return this;
    }

    public ConfigSettingContractComputeV0 build() {
      ConfigSettingContractComputeV0 val = new ConfigSettingContractComputeV0();
      val.setLedgerMaxInstructions(this.ledgerMaxInstructions);
      val.setTxMaxInstructions(this.txMaxInstructions);
      val.setFeeRatePerInstructionsIncrement(this.feeRatePerInstructionsIncrement);
      val.setTxMemoryLimit(this.txMemoryLimit);
      return val;
    }
  }
}
