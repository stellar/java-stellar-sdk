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

//  struct CreatePassiveSellOfferOp
//  {
//      Asset selling; // A
//      Asset buying;  // B
//      int64 amount;  // amount taker gets
//      Price price;   // cost of A in terms of B
//  };

//  ===========================================================================
public class CreatePassiveSellOfferOp implements XdrElement {
  public CreatePassiveSellOfferOp() {}

  private Asset selling;

  public Asset getSelling() {
    return this.selling;
  }

  public void setSelling(Asset value) {
    this.selling = value;
  }

  private Asset buying;

  public Asset getBuying() {
    return this.buying;
  }

  public void setBuying(Asset value) {
    this.buying = value;
  }

  private Int64 amount;

  public Int64 getAmount() {
    return this.amount;
  }

  public void setAmount(Int64 value) {
    this.amount = value;
  }

  private Price price;

  public Price getPrice() {
    return this.price;
  }

  public void setPrice(Price value) {
    this.price = value;
  }

  public static void encode(
      XdrDataOutputStream stream, CreatePassiveSellOfferOp encodedCreatePassiveSellOfferOp)
      throws IOException {
    Asset.encode(stream, encodedCreatePassiveSellOfferOp.selling);
    Asset.encode(stream, encodedCreatePassiveSellOfferOp.buying);
    Int64.encode(stream, encodedCreatePassiveSellOfferOp.amount);
    Price.encode(stream, encodedCreatePassiveSellOfferOp.price);
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static CreatePassiveSellOfferOp decode(XdrDataInputStream stream) throws IOException {
    CreatePassiveSellOfferOp decodedCreatePassiveSellOfferOp = new CreatePassiveSellOfferOp();
    decodedCreatePassiveSellOfferOp.selling = Asset.decode(stream);
    decodedCreatePassiveSellOfferOp.buying = Asset.decode(stream);
    decodedCreatePassiveSellOfferOp.amount = Int64.decode(stream);
    decodedCreatePassiveSellOfferOp.price = Price.decode(stream);
    return decodedCreatePassiveSellOfferOp;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.selling, this.buying, this.amount, this.price);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof CreatePassiveSellOfferOp)) {
      return false;
    }

    CreatePassiveSellOfferOp other = (CreatePassiveSellOfferOp) object;
    return Objects.equals(this.selling, other.selling)
        && Objects.equals(this.buying, other.buying)
        && Objects.equals(this.amount, other.amount)
        && Objects.equals(this.price, other.price);
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

  public static CreatePassiveSellOfferOp fromXdrBase64(String xdr) throws IOException {
    byte[] bytes = Base64Factory.getInstance().decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static CreatePassiveSellOfferOp fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }

  public static final class Builder {
    private Asset selling;
    private Asset buying;
    private Int64 amount;
    private Price price;

    public Builder selling(Asset selling) {
      this.selling = selling;
      return this;
    }

    public Builder buying(Asset buying) {
      this.buying = buying;
      return this;
    }

    public Builder amount(Int64 amount) {
      this.amount = amount;
      return this;
    }

    public Builder price(Price price) {
      this.price = price;
      return this;
    }

    public CreatePassiveSellOfferOp build() {
      CreatePassiveSellOfferOp val = new CreatePassiveSellOfferOp();
      val.setSelling(this.selling);
      val.setBuying(this.buying);
      val.setAmount(this.amount);
      val.setPrice(this.price);
      return val;
    }
  }
}
