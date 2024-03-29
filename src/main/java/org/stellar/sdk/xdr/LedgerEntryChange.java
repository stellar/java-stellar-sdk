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

//  union LedgerEntryChange switch (LedgerEntryChangeType type)
//  {
//  case LEDGER_ENTRY_CREATED:
//      LedgerEntry created;
//  case LEDGER_ENTRY_UPDATED:
//      LedgerEntry updated;
//  case LEDGER_ENTRY_REMOVED:
//      LedgerKey removed;
//  case LEDGER_ENTRY_STATE:
//      LedgerEntry state;
//  };

//  ===========================================================================
public class LedgerEntryChange implements XdrElement {
  public LedgerEntryChange() {}

  LedgerEntryChangeType type;

  public LedgerEntryChangeType getDiscriminant() {
    return this.type;
  }

  public void setDiscriminant(LedgerEntryChangeType value) {
    this.type = value;
  }

  private LedgerEntry created;

  public LedgerEntry getCreated() {
    return this.created;
  }

  public void setCreated(LedgerEntry value) {
    this.created = value;
  }

  private LedgerEntry updated;

  public LedgerEntry getUpdated() {
    return this.updated;
  }

  public void setUpdated(LedgerEntry value) {
    this.updated = value;
  }

  private LedgerKey removed;

  public LedgerKey getRemoved() {
    return this.removed;
  }

  public void setRemoved(LedgerKey value) {
    this.removed = value;
  }

  private LedgerEntry state;

  public LedgerEntry getState() {
    return this.state;
  }

  public void setState(LedgerEntry value) {
    this.state = value;
  }

  public static final class Builder {
    private LedgerEntryChangeType discriminant;
    private LedgerEntry created;
    private LedgerEntry updated;
    private LedgerKey removed;
    private LedgerEntry state;

    public Builder discriminant(LedgerEntryChangeType discriminant) {
      this.discriminant = discriminant;
      return this;
    }

    public Builder created(LedgerEntry created) {
      this.created = created;
      return this;
    }

    public Builder updated(LedgerEntry updated) {
      this.updated = updated;
      return this;
    }

    public Builder removed(LedgerKey removed) {
      this.removed = removed;
      return this;
    }

    public Builder state(LedgerEntry state) {
      this.state = state;
      return this;
    }

    public LedgerEntryChange build() {
      LedgerEntryChange val = new LedgerEntryChange();
      val.setDiscriminant(discriminant);
      val.setCreated(this.created);
      val.setUpdated(this.updated);
      val.setRemoved(this.removed);
      val.setState(this.state);
      return val;
    }
  }

  public static void encode(XdrDataOutputStream stream, LedgerEntryChange encodedLedgerEntryChange)
      throws IOException {
    // Xdrgen::AST::Identifier
    // LedgerEntryChangeType
    stream.writeInt(encodedLedgerEntryChange.getDiscriminant().getValue());
    switch (encodedLedgerEntryChange.getDiscriminant()) {
      case LEDGER_ENTRY_CREATED:
        LedgerEntry.encode(stream, encodedLedgerEntryChange.created);
        break;
      case LEDGER_ENTRY_UPDATED:
        LedgerEntry.encode(stream, encodedLedgerEntryChange.updated);
        break;
      case LEDGER_ENTRY_REMOVED:
        LedgerKey.encode(stream, encodedLedgerEntryChange.removed);
        break;
      case LEDGER_ENTRY_STATE:
        LedgerEntry.encode(stream, encodedLedgerEntryChange.state);
        break;
    }
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static LedgerEntryChange decode(XdrDataInputStream stream) throws IOException {
    LedgerEntryChange decodedLedgerEntryChange = new LedgerEntryChange();
    LedgerEntryChangeType discriminant = LedgerEntryChangeType.decode(stream);
    decodedLedgerEntryChange.setDiscriminant(discriminant);
    switch (decodedLedgerEntryChange.getDiscriminant()) {
      case LEDGER_ENTRY_CREATED:
        decodedLedgerEntryChange.created = LedgerEntry.decode(stream);
        break;
      case LEDGER_ENTRY_UPDATED:
        decodedLedgerEntryChange.updated = LedgerEntry.decode(stream);
        break;
      case LEDGER_ENTRY_REMOVED:
        decodedLedgerEntryChange.removed = LedgerKey.decode(stream);
        break;
      case LEDGER_ENTRY_STATE:
        decodedLedgerEntryChange.state = LedgerEntry.decode(stream);
        break;
    }
    return decodedLedgerEntryChange;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.created, this.updated, this.removed, this.state, this.type);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof LedgerEntryChange)) {
      return false;
    }

    LedgerEntryChange other = (LedgerEntryChange) object;
    return Objects.equals(this.created, other.created)
        && Objects.equals(this.updated, other.updated)
        && Objects.equals(this.removed, other.removed)
        && Objects.equals(this.state, other.state)
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

  public static LedgerEntryChange fromXdrBase64(String xdr) throws IOException {
    byte[] bytes = Base64Factory.getInstance().decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static LedgerEntryChange fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }
}
