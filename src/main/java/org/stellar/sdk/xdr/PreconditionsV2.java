// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.stellar.sdk.xdr;

import com.google.common.base.Objects;
import java.io.IOException;
import java.util.Arrays;

// === xdr source ============================================================

//  struct PreconditionsV2
//  {
//      TimeBounds* timeBounds;
//
//      // Transaction only valid for ledger numbers n such that
//      // minLedger <= n < maxLedger (if maxLedger == 0, then
//      // only minLedger is checked)
//      LedgerBounds* ledgerBounds;
//
//      // If NULL, only valid when sourceAccount's sequence number
//      // is seqNum - 1.  Otherwise, valid when sourceAccount's
//      // sequence number n satisfies minSeqNum <= n < tx.seqNum.
//      // Note that after execution the account's sequence number
//      // is always raised to tx.seqNum, and a transaction is not
//      // valid if tx.seqNum is too high to ensure replay protection.
//      SequenceNumber* minSeqNum;
//
//      // For the transaction to be valid, the current ledger time must
//      // be at least minSeqAge greater than sourceAccount's seqTime.
//      Duration minSeqAge;
//
//      // For the transaction to be valid, the current ledger number
//      // must be at least minSeqLedgerGap greater than sourceAccount's
//      // seqLedger.
//      uint32 minSeqLedgerGap;
//
//      // For the transaction to be valid, there must be a signature
//      // corresponding to every Signer in this array, even if the
//      // signature is not otherwise required by the sourceAccount or
//      // operations.
//      SignerKey extraSigners<2>;
//  };

//  ===========================================================================
public class PreconditionsV2 implements XdrElement {
  public PreconditionsV2() {}

  private TimeBounds timeBounds;

  public TimeBounds getTimeBounds() {
    return this.timeBounds;
  }

  public void setTimeBounds(TimeBounds value) {
    this.timeBounds = value;
  }

  private LedgerBounds ledgerBounds;

  public LedgerBounds getLedgerBounds() {
    return this.ledgerBounds;
  }

  public void setLedgerBounds(LedgerBounds value) {
    this.ledgerBounds = value;
  }

  private SequenceNumber minSeqNum;

  public SequenceNumber getMinSeqNum() {
    return this.minSeqNum;
  }

  public void setMinSeqNum(SequenceNumber value) {
    this.minSeqNum = value;
  }

  private Duration minSeqAge;

  public Duration getMinSeqAge() {
    return this.minSeqAge;
  }

  public void setMinSeqAge(Duration value) {
    this.minSeqAge = value;
  }

  private Uint32 minSeqLedgerGap;

  public Uint32 getMinSeqLedgerGap() {
    return this.minSeqLedgerGap;
  }

  public void setMinSeqLedgerGap(Uint32 value) {
    this.minSeqLedgerGap = value;
  }

  private SignerKey[] extraSigners;

  public SignerKey[] getExtraSigners() {
    return this.extraSigners;
  }

  public void setExtraSigners(SignerKey[] value) {
    this.extraSigners = value;
  }

  public static void encode(XdrDataOutputStream stream, PreconditionsV2 encodedPreconditionsV2)
      throws IOException {
    if (encodedPreconditionsV2.timeBounds != null) {
      stream.writeInt(1);
      TimeBounds.encode(stream, encodedPreconditionsV2.timeBounds);
    } else {
      stream.writeInt(0);
    }
    if (encodedPreconditionsV2.ledgerBounds != null) {
      stream.writeInt(1);
      LedgerBounds.encode(stream, encodedPreconditionsV2.ledgerBounds);
    } else {
      stream.writeInt(0);
    }
    if (encodedPreconditionsV2.minSeqNum != null) {
      stream.writeInt(1);
      SequenceNumber.encode(stream, encodedPreconditionsV2.minSeqNum);
    } else {
      stream.writeInt(0);
    }
    Duration.encode(stream, encodedPreconditionsV2.minSeqAge);
    Uint32.encode(stream, encodedPreconditionsV2.minSeqLedgerGap);
    int extraSignerssize = encodedPreconditionsV2.getExtraSigners().length;
    stream.writeInt(extraSignerssize);
    for (int i = 0; i < extraSignerssize; i++) {
      SignerKey.encode(stream, encodedPreconditionsV2.extraSigners[i]);
    }
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static PreconditionsV2 decode(XdrDataInputStream stream) throws IOException {
    PreconditionsV2 decodedPreconditionsV2 = new PreconditionsV2();
    int timeBoundsPresent = stream.readInt();
    if (timeBoundsPresent != 0) {
      decodedPreconditionsV2.timeBounds = TimeBounds.decode(stream);
    }
    int ledgerBoundsPresent = stream.readInt();
    if (ledgerBoundsPresent != 0) {
      decodedPreconditionsV2.ledgerBounds = LedgerBounds.decode(stream);
    }
    int minSeqNumPresent = stream.readInt();
    if (minSeqNumPresent != 0) {
      decodedPreconditionsV2.minSeqNum = SequenceNumber.decode(stream);
    }
    decodedPreconditionsV2.minSeqAge = Duration.decode(stream);
    decodedPreconditionsV2.minSeqLedgerGap = Uint32.decode(stream);
    int extraSignerssize = stream.readInt();
    decodedPreconditionsV2.extraSigners = new SignerKey[extraSignerssize];
    for (int i = 0; i < extraSignerssize; i++) {
      decodedPreconditionsV2.extraSigners[i] = SignerKey.decode(stream);
    }
    return decodedPreconditionsV2;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(
        this.timeBounds,
        this.ledgerBounds,
        this.minSeqNum,
        this.minSeqAge,
        this.minSeqLedgerGap,
        Arrays.hashCode(this.extraSigners));
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof PreconditionsV2)) {
      return false;
    }

    PreconditionsV2 other = (PreconditionsV2) object;
    return Objects.equal(this.timeBounds, other.timeBounds)
        && Objects.equal(this.ledgerBounds, other.ledgerBounds)
        && Objects.equal(this.minSeqNum, other.minSeqNum)
        && Objects.equal(this.minSeqAge, other.minSeqAge)
        && Objects.equal(this.minSeqLedgerGap, other.minSeqLedgerGap)
        && Arrays.equals(this.extraSigners, other.extraSigners);
  }

  public static final class Builder {
    private TimeBounds timeBounds;
    private LedgerBounds ledgerBounds;
    private SequenceNumber minSeqNum;
    private Duration minSeqAge;
    private Uint32 minSeqLedgerGap;
    private SignerKey[] extraSigners;

    public Builder timeBounds(TimeBounds timeBounds) {
      this.timeBounds = timeBounds;
      return this;
    }

    public Builder ledgerBounds(LedgerBounds ledgerBounds) {
      this.ledgerBounds = ledgerBounds;
      return this;
    }

    public Builder minSeqNum(SequenceNumber minSeqNum) {
      this.minSeqNum = minSeqNum;
      return this;
    }

    public Builder minSeqAge(Duration minSeqAge) {
      this.minSeqAge = minSeqAge;
      return this;
    }

    public Builder minSeqLedgerGap(Uint32 minSeqLedgerGap) {
      this.minSeqLedgerGap = minSeqLedgerGap;
      return this;
    }

    public Builder extraSigners(SignerKey[] extraSigners) {
      this.extraSigners = extraSigners;
      return this;
    }

    public PreconditionsV2 build() {
      PreconditionsV2 val = new PreconditionsV2();
      val.setTimeBounds(timeBounds);
      val.setLedgerBounds(ledgerBounds);
      val.setMinSeqNum(minSeqNum);
      val.setMinSeqAge(minSeqAge);
      val.setMinSeqLedgerGap(minSeqLedgerGap);
      val.setExtraSigners(extraSigners);
      return val;
    }
  }
}
