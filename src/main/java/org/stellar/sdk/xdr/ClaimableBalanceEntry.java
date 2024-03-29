// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.stellar.sdk.xdr;

import static org.stellar.sdk.xdr.Constants.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import org.stellar.sdk.Base64Factory;

// === xdr source ============================================================

//  struct ClaimableBalanceEntry
//  {
//      // Unique identifier for this ClaimableBalanceEntry
//      ClaimableBalanceID balanceID;
//
//      // List of claimants with associated predicate
//      Claimant claimants<10>;
//
//      // Any asset including native
//      Asset asset;
//
//      // Amount of asset
//      int64 amount;
//
//      // reserved for future use
//      union switch (int v)
//      {
//      case 0:
//          void;
//      case 1:
//          ClaimableBalanceEntryExtensionV1 v1;
//      }
//      ext;
//  };

//  ===========================================================================
public class ClaimableBalanceEntry implements XdrElement {
  public ClaimableBalanceEntry() {}

  private ClaimableBalanceID balanceID;

  public ClaimableBalanceID getBalanceID() {
    return this.balanceID;
  }

  public void setBalanceID(ClaimableBalanceID value) {
    this.balanceID = value;
  }

  private Claimant[] claimants;

  public Claimant[] getClaimants() {
    return this.claimants;
  }

  public void setClaimants(Claimant[] value) {
    this.claimants = value;
  }

  private Asset asset;

  public Asset getAsset() {
    return this.asset;
  }

  public void setAsset(Asset value) {
    this.asset = value;
  }

  private Int64 amount;

  public Int64 getAmount() {
    return this.amount;
  }

  public void setAmount(Int64 value) {
    this.amount = value;
  }

  private ClaimableBalanceEntryExt ext;

  public ClaimableBalanceEntryExt getExt() {
    return this.ext;
  }

  public void setExt(ClaimableBalanceEntryExt value) {
    this.ext = value;
  }

  public static void encode(
      XdrDataOutputStream stream, ClaimableBalanceEntry encodedClaimableBalanceEntry)
      throws IOException {
    ClaimableBalanceID.encode(stream, encodedClaimableBalanceEntry.balanceID);
    int claimantssize = encodedClaimableBalanceEntry.getClaimants().length;
    stream.writeInt(claimantssize);
    for (int i = 0; i < claimantssize; i++) {
      Claimant.encode(stream, encodedClaimableBalanceEntry.claimants[i]);
    }
    Asset.encode(stream, encodedClaimableBalanceEntry.asset);
    Int64.encode(stream, encodedClaimableBalanceEntry.amount);
    ClaimableBalanceEntryExt.encode(stream, encodedClaimableBalanceEntry.ext);
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static ClaimableBalanceEntry decode(XdrDataInputStream stream) throws IOException {
    ClaimableBalanceEntry decodedClaimableBalanceEntry = new ClaimableBalanceEntry();
    decodedClaimableBalanceEntry.balanceID = ClaimableBalanceID.decode(stream);
    int claimantssize = stream.readInt();
    decodedClaimableBalanceEntry.claimants = new Claimant[claimantssize];
    for (int i = 0; i < claimantssize; i++) {
      decodedClaimableBalanceEntry.claimants[i] = Claimant.decode(stream);
    }
    decodedClaimableBalanceEntry.asset = Asset.decode(stream);
    decodedClaimableBalanceEntry.amount = Int64.decode(stream);
    decodedClaimableBalanceEntry.ext = ClaimableBalanceEntryExt.decode(stream);
    return decodedClaimableBalanceEntry;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        this.balanceID, Arrays.hashCode(this.claimants), this.asset, this.amount, this.ext);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof ClaimableBalanceEntry)) {
      return false;
    }

    ClaimableBalanceEntry other = (ClaimableBalanceEntry) object;
    return Objects.equals(this.balanceID, other.balanceID)
        && Arrays.equals(this.claimants, other.claimants)
        && Objects.equals(this.asset, other.asset)
        && Objects.equals(this.amount, other.amount)
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

  public static ClaimableBalanceEntry fromXdrBase64(String xdr) throws IOException {
    byte[] bytes = Base64Factory.getInstance().decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static ClaimableBalanceEntry fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }

  public static final class Builder {
    private ClaimableBalanceID balanceID;
    private Claimant[] claimants;
    private Asset asset;
    private Int64 amount;
    private ClaimableBalanceEntryExt ext;

    public Builder balanceID(ClaimableBalanceID balanceID) {
      this.balanceID = balanceID;
      return this;
    }

    public Builder claimants(Claimant[] claimants) {
      this.claimants = claimants;
      return this;
    }

    public Builder asset(Asset asset) {
      this.asset = asset;
      return this;
    }

    public Builder amount(Int64 amount) {
      this.amount = amount;
      return this;
    }

    public Builder ext(ClaimableBalanceEntryExt ext) {
      this.ext = ext;
      return this;
    }

    public ClaimableBalanceEntry build() {
      ClaimableBalanceEntry val = new ClaimableBalanceEntry();
      val.setBalanceID(this.balanceID);
      val.setClaimants(this.claimants);
      val.setAsset(this.asset);
      val.setAmount(this.amount);
      val.setExt(this.ext);
      return val;
    }
  }

  public static class ClaimableBalanceEntryExt implements XdrElement {
    public ClaimableBalanceEntryExt() {}

    Integer v;

    public Integer getDiscriminant() {
      return this.v;
    }

    public void setDiscriminant(Integer value) {
      this.v = value;
    }

    private ClaimableBalanceEntryExtensionV1 v1;

    public ClaimableBalanceEntryExtensionV1 getV1() {
      return this.v1;
    }

    public void setV1(ClaimableBalanceEntryExtensionV1 value) {
      this.v1 = value;
    }

    public static final class Builder {
      private Integer discriminant;
      private ClaimableBalanceEntryExtensionV1 v1;

      public Builder discriminant(Integer discriminant) {
        this.discriminant = discriminant;
        return this;
      }

      public Builder v1(ClaimableBalanceEntryExtensionV1 v1) {
        this.v1 = v1;
        return this;
      }

      public ClaimableBalanceEntryExt build() {
        ClaimableBalanceEntryExt val = new ClaimableBalanceEntryExt();
        val.setDiscriminant(discriminant);
        val.setV1(this.v1);
        return val;
      }
    }

    public static void encode(
        XdrDataOutputStream stream, ClaimableBalanceEntryExt encodedClaimableBalanceEntryExt)
        throws IOException {
      // Xdrgen::AST::Typespecs::Int
      // Integer
      stream.writeInt(encodedClaimableBalanceEntryExt.getDiscriminant().intValue());
      switch (encodedClaimableBalanceEntryExt.getDiscriminant()) {
        case 0:
          break;
        case 1:
          ClaimableBalanceEntryExtensionV1.encode(stream, encodedClaimableBalanceEntryExt.v1);
          break;
      }
    }

    public void encode(XdrDataOutputStream stream) throws IOException {
      encode(stream, this);
    }

    public static ClaimableBalanceEntryExt decode(XdrDataInputStream stream) throws IOException {
      ClaimableBalanceEntryExt decodedClaimableBalanceEntryExt = new ClaimableBalanceEntryExt();
      Integer discriminant = stream.readInt();
      decodedClaimableBalanceEntryExt.setDiscriminant(discriminant);
      switch (decodedClaimableBalanceEntryExt.getDiscriminant()) {
        case 0:
          break;
        case 1:
          decodedClaimableBalanceEntryExt.v1 = ClaimableBalanceEntryExtensionV1.decode(stream);
          break;
      }
      return decodedClaimableBalanceEntryExt;
    }

    @Override
    public int hashCode() {
      return Objects.hash(this.v1, this.v);
    }

    @Override
    public boolean equals(Object object) {
      if (!(object instanceof ClaimableBalanceEntryExt)) {
        return false;
      }

      ClaimableBalanceEntryExt other = (ClaimableBalanceEntryExt) object;
      return Objects.equals(this.v1, other.v1) && Objects.equals(this.v, other.v);
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

    public static ClaimableBalanceEntryExt fromXdrBase64(String xdr) throws IOException {
      byte[] bytes = Base64Factory.getInstance().decode(xdr);
      return fromXdrByteArray(bytes);
    }

    public static ClaimableBalanceEntryExt fromXdrByteArray(byte[] xdr) throws IOException {
      ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
      XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
      return decode(xdrDataInputStream);
    }
  }
}
