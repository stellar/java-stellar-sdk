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

//  struct Liabilities
//  {
//      int64 buying;
//      int64 selling;
//  };

//  ===========================================================================
public class Liabilities implements XdrElement {
  public Liabilities() {}

  private Int64 buying;

  public Int64 getBuying() {
    return this.buying;
  }

  public void setBuying(Int64 value) {
    this.buying = value;
  }

  private Int64 selling;

  public Int64 getSelling() {
    return this.selling;
  }

  public void setSelling(Int64 value) {
    this.selling = value;
  }

  public static void encode(XdrDataOutputStream stream, Liabilities encodedLiabilities)
      throws IOException {
    Int64.encode(stream, encodedLiabilities.buying);
    Int64.encode(stream, encodedLiabilities.selling);
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static Liabilities decode(XdrDataInputStream stream) throws IOException {
    Liabilities decodedLiabilities = new Liabilities();
    decodedLiabilities.buying = Int64.decode(stream);
    decodedLiabilities.selling = Int64.decode(stream);
    return decodedLiabilities;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.buying, this.selling);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof Liabilities)) {
      return false;
    }

    Liabilities other = (Liabilities) object;
    return Objects.equals(this.buying, other.buying) && Objects.equals(this.selling, other.selling);
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

  public static Liabilities fromXdrBase64(String xdr) throws IOException {
    byte[] bytes = Base64Factory.getInstance().decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static Liabilities fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }

  public static final class Builder {
    private Int64 buying;
    private Int64 selling;

    public Builder buying(Int64 buying) {
      this.buying = buying;
      return this;
    }

    public Builder selling(Int64 selling) {
      this.selling = selling;
      return this;
    }

    public Liabilities build() {
      Liabilities val = new Liabilities();
      val.setBuying(this.buying);
      val.setSelling(this.selling);
      return val;
    }
  }
}
