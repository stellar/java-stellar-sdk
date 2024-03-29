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

//  struct LedgerEntryExtensionV1
//  {
//      SponsorshipDescriptor sponsoringID;
//
//      union switch (int v)
//      {
//      case 0:
//          void;
//      }
//      ext;
//  };

//  ===========================================================================
public class LedgerEntryExtensionV1 implements XdrElement {
  public LedgerEntryExtensionV1() {}

  private SponsorshipDescriptor sponsoringID;

  public SponsorshipDescriptor getSponsoringID() {
    return this.sponsoringID;
  }

  public void setSponsoringID(SponsorshipDescriptor value) {
    this.sponsoringID = value;
  }

  private LedgerEntryExtensionV1Ext ext;

  public LedgerEntryExtensionV1Ext getExt() {
    return this.ext;
  }

  public void setExt(LedgerEntryExtensionV1Ext value) {
    this.ext = value;
  }

  public static void encode(
      XdrDataOutputStream stream, LedgerEntryExtensionV1 encodedLedgerEntryExtensionV1)
      throws IOException {
    SponsorshipDescriptor.encode(stream, encodedLedgerEntryExtensionV1.sponsoringID);
    LedgerEntryExtensionV1Ext.encode(stream, encodedLedgerEntryExtensionV1.ext);
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static LedgerEntryExtensionV1 decode(XdrDataInputStream stream) throws IOException {
    LedgerEntryExtensionV1 decodedLedgerEntryExtensionV1 = new LedgerEntryExtensionV1();
    decodedLedgerEntryExtensionV1.sponsoringID = SponsorshipDescriptor.decode(stream);
    decodedLedgerEntryExtensionV1.ext = LedgerEntryExtensionV1Ext.decode(stream);
    return decodedLedgerEntryExtensionV1;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.sponsoringID, this.ext);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof LedgerEntryExtensionV1)) {
      return false;
    }

    LedgerEntryExtensionV1 other = (LedgerEntryExtensionV1) object;
    return Objects.equals(this.sponsoringID, other.sponsoringID)
        && Objects.equals(this.ext, other.ext);
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

  public static LedgerEntryExtensionV1 fromXdrBase64(String xdr) throws IOException {
    byte[] bytes = Base64Factory.getInstance().decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static LedgerEntryExtensionV1 fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }

  public static final class Builder {
    private SponsorshipDescriptor sponsoringID;
    private LedgerEntryExtensionV1Ext ext;

    public Builder sponsoringID(SponsorshipDescriptor sponsoringID) {
      this.sponsoringID = sponsoringID;
      return this;
    }

    public Builder ext(LedgerEntryExtensionV1Ext ext) {
      this.ext = ext;
      return this;
    }

    public LedgerEntryExtensionV1 build() {
      LedgerEntryExtensionV1 val = new LedgerEntryExtensionV1();
      val.setSponsoringID(this.sponsoringID);
      val.setExt(this.ext);
      return val;
    }
  }

  public static class LedgerEntryExtensionV1Ext implements XdrElement {
    public LedgerEntryExtensionV1Ext() {}

    Integer v;

    public Integer getDiscriminant() {
      return this.v;
    }

    public void setDiscriminant(Integer value) {
      this.v = value;
    }

    public static final class Builder {
      private Integer discriminant;

      public Builder discriminant(Integer discriminant) {
        this.discriminant = discriminant;
        return this;
      }

      public LedgerEntryExtensionV1Ext build() {
        LedgerEntryExtensionV1Ext val = new LedgerEntryExtensionV1Ext();
        val.setDiscriminant(discriminant);
        return val;
      }
    }

    public static void encode(
        XdrDataOutputStream stream, LedgerEntryExtensionV1Ext encodedLedgerEntryExtensionV1Ext)
        throws IOException {
      // Xdrgen::AST::Typespecs::Int
      // Integer
      stream.writeInt(encodedLedgerEntryExtensionV1Ext.getDiscriminant().intValue());
      switch (encodedLedgerEntryExtensionV1Ext.getDiscriminant()) {
        case 0:
          break;
      }
    }

    public void encode(XdrDataOutputStream stream) throws IOException {
      encode(stream, this);
    }

    public static LedgerEntryExtensionV1Ext decode(XdrDataInputStream stream) throws IOException {
      LedgerEntryExtensionV1Ext decodedLedgerEntryExtensionV1Ext = new LedgerEntryExtensionV1Ext();
      Integer discriminant = stream.readInt();
      decodedLedgerEntryExtensionV1Ext.setDiscriminant(discriminant);
      switch (decodedLedgerEntryExtensionV1Ext.getDiscriminant()) {
        case 0:
          break;
      }
      return decodedLedgerEntryExtensionV1Ext;
    }

    @Override
    public int hashCode() {
      return Objects.hash(this.v);
    }

    @Override
    public boolean equals(Object object) {
      if (!(object instanceof LedgerEntryExtensionV1Ext)) {
        return false;
      }

      LedgerEntryExtensionV1Ext other = (LedgerEntryExtensionV1Ext) object;
      return Objects.equals(this.v, other.v);
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

    public static LedgerEntryExtensionV1Ext fromXdrBase64(String xdr) throws IOException {
      byte[] bytes = Base64Factory.getInstance().decode(xdr);
      return fromXdrByteArray(bytes);
    }

    public static LedgerEntryExtensionV1Ext fromXdrByteArray(byte[] xdr) throws IOException {
      ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
      XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
      return decode(xdrDataInputStream);
    }
  }
}
