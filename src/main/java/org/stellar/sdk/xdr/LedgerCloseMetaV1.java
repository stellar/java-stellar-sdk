// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.stellar.sdk.xdr;

import static org.stellar.sdk.xdr.Constants.*;

import com.google.common.base.Objects;
import com.google.common.io.BaseEncoding;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

// === xdr source ============================================================

//  struct LedgerCloseMetaV1
//  {
//      LedgerHeaderHistoryEntry ledgerHeader;
//
//      GeneralizedTransactionSet txSet;
//
//      // NB: transactions are sorted in apply order here
//      // fees for all transactions are processed first
//      // followed by applying transactions
//      TransactionResultMeta txProcessing<>;
//
//      // upgrades are applied last
//      UpgradeEntryMeta upgradesProcessing<>;
//
//      // other misc information attached to the ledger close
//      SCPHistoryEntry scpInfo<>;
//  };

//  ===========================================================================
public class LedgerCloseMetaV1 implements XdrElement {
  public LedgerCloseMetaV1() {}

  private LedgerHeaderHistoryEntry ledgerHeader;

  public LedgerHeaderHistoryEntry getLedgerHeader() {
    return this.ledgerHeader;
  }

  public void setLedgerHeader(LedgerHeaderHistoryEntry value) {
    this.ledgerHeader = value;
  }

  private GeneralizedTransactionSet txSet;

  public GeneralizedTransactionSet getTxSet() {
    return this.txSet;
  }

  public void setTxSet(GeneralizedTransactionSet value) {
    this.txSet = value;
  }

  private TransactionResultMeta[] txProcessing;

  public TransactionResultMeta[] getTxProcessing() {
    return this.txProcessing;
  }

  public void setTxProcessing(TransactionResultMeta[] value) {
    this.txProcessing = value;
  }

  private UpgradeEntryMeta[] upgradesProcessing;

  public UpgradeEntryMeta[] getUpgradesProcessing() {
    return this.upgradesProcessing;
  }

  public void setUpgradesProcessing(UpgradeEntryMeta[] value) {
    this.upgradesProcessing = value;
  }

  private SCPHistoryEntry[] scpInfo;

  public SCPHistoryEntry[] getScpInfo() {
    return this.scpInfo;
  }

  public void setScpInfo(SCPHistoryEntry[] value) {
    this.scpInfo = value;
  }

  public static void encode(XdrDataOutputStream stream, LedgerCloseMetaV1 encodedLedgerCloseMetaV1)
      throws IOException {
    LedgerHeaderHistoryEntry.encode(stream, encodedLedgerCloseMetaV1.ledgerHeader);
    GeneralizedTransactionSet.encode(stream, encodedLedgerCloseMetaV1.txSet);
    int txProcessingsize = encodedLedgerCloseMetaV1.getTxProcessing().length;
    stream.writeInt(txProcessingsize);
    for (int i = 0; i < txProcessingsize; i++) {
      TransactionResultMeta.encode(stream, encodedLedgerCloseMetaV1.txProcessing[i]);
    }
    int upgradesProcessingsize = encodedLedgerCloseMetaV1.getUpgradesProcessing().length;
    stream.writeInt(upgradesProcessingsize);
    for (int i = 0; i < upgradesProcessingsize; i++) {
      UpgradeEntryMeta.encode(stream, encodedLedgerCloseMetaV1.upgradesProcessing[i]);
    }
    int scpInfosize = encodedLedgerCloseMetaV1.getScpInfo().length;
    stream.writeInt(scpInfosize);
    for (int i = 0; i < scpInfosize; i++) {
      SCPHistoryEntry.encode(stream, encodedLedgerCloseMetaV1.scpInfo[i]);
    }
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static LedgerCloseMetaV1 decode(XdrDataInputStream stream) throws IOException {
    LedgerCloseMetaV1 decodedLedgerCloseMetaV1 = new LedgerCloseMetaV1();
    decodedLedgerCloseMetaV1.ledgerHeader = LedgerHeaderHistoryEntry.decode(stream);
    decodedLedgerCloseMetaV1.txSet = GeneralizedTransactionSet.decode(stream);
    int txProcessingsize = stream.readInt();
    decodedLedgerCloseMetaV1.txProcessing = new TransactionResultMeta[txProcessingsize];
    for (int i = 0; i < txProcessingsize; i++) {
      decodedLedgerCloseMetaV1.txProcessing[i] = TransactionResultMeta.decode(stream);
    }
    int upgradesProcessingsize = stream.readInt();
    decodedLedgerCloseMetaV1.upgradesProcessing = new UpgradeEntryMeta[upgradesProcessingsize];
    for (int i = 0; i < upgradesProcessingsize; i++) {
      decodedLedgerCloseMetaV1.upgradesProcessing[i] = UpgradeEntryMeta.decode(stream);
    }
    int scpInfosize = stream.readInt();
    decodedLedgerCloseMetaV1.scpInfo = new SCPHistoryEntry[scpInfosize];
    for (int i = 0; i < scpInfosize; i++) {
      decodedLedgerCloseMetaV1.scpInfo[i] = SCPHistoryEntry.decode(stream);
    }
    return decodedLedgerCloseMetaV1;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(
        this.ledgerHeader,
        this.txSet,
        Arrays.hashCode(this.txProcessing),
        Arrays.hashCode(this.upgradesProcessing),
        Arrays.hashCode(this.scpInfo));
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof LedgerCloseMetaV1)) {
      return false;
    }

    LedgerCloseMetaV1 other = (LedgerCloseMetaV1) object;
    return Objects.equal(this.ledgerHeader, other.ledgerHeader)
        && Objects.equal(this.txSet, other.txSet)
        && Arrays.equals(this.txProcessing, other.txProcessing)
        && Arrays.equals(this.upgradesProcessing, other.upgradesProcessing)
        && Arrays.equals(this.scpInfo, other.scpInfo);
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

  public static LedgerCloseMetaV1 fromXdrBase64(String xdr) throws IOException {
    BaseEncoding base64Encoding = BaseEncoding.base64();
    byte[] bytes = base64Encoding.decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static LedgerCloseMetaV1 fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }

  public static final class Builder {
    private LedgerHeaderHistoryEntry ledgerHeader;
    private GeneralizedTransactionSet txSet;
    private TransactionResultMeta[] txProcessing;
    private UpgradeEntryMeta[] upgradesProcessing;
    private SCPHistoryEntry[] scpInfo;

    public Builder ledgerHeader(LedgerHeaderHistoryEntry ledgerHeader) {
      this.ledgerHeader = ledgerHeader;
      return this;
    }

    public Builder txSet(GeneralizedTransactionSet txSet) {
      this.txSet = txSet;
      return this;
    }

    public Builder txProcessing(TransactionResultMeta[] txProcessing) {
      this.txProcessing = txProcessing;
      return this;
    }

    public Builder upgradesProcessing(UpgradeEntryMeta[] upgradesProcessing) {
      this.upgradesProcessing = upgradesProcessing;
      return this;
    }

    public Builder scpInfo(SCPHistoryEntry[] scpInfo) {
      this.scpInfo = scpInfo;
      return this;
    }

    public LedgerCloseMetaV1 build() {
      LedgerCloseMetaV1 val = new LedgerCloseMetaV1();
      val.setLedgerHeader(this.ledgerHeader);
      val.setTxSet(this.txSet);
      val.setTxProcessing(this.txProcessing);
      val.setUpgradesProcessing(this.upgradesProcessing);
      val.setScpInfo(this.scpInfo);
      return val;
    }
  }
}
