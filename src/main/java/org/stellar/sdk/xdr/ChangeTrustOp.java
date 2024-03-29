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

//  struct ChangeTrustOp
//  {
//      ChangeTrustAsset line;
//
//      // if limit is set to 0, deletes the trust line
//      int64 limit;
//  };

//  ===========================================================================
public class ChangeTrustOp implements XdrElement {
  public ChangeTrustOp() {}

  private ChangeTrustAsset line;

  public ChangeTrustAsset getLine() {
    return this.line;
  }

  public void setLine(ChangeTrustAsset value) {
    this.line = value;
  }

  private Int64 limit;

  public Int64 getLimit() {
    return this.limit;
  }

  public void setLimit(Int64 value) {
    this.limit = value;
  }

  public static void encode(XdrDataOutputStream stream, ChangeTrustOp encodedChangeTrustOp)
      throws IOException {
    ChangeTrustAsset.encode(stream, encodedChangeTrustOp.line);
    Int64.encode(stream, encodedChangeTrustOp.limit);
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static ChangeTrustOp decode(XdrDataInputStream stream) throws IOException {
    ChangeTrustOp decodedChangeTrustOp = new ChangeTrustOp();
    decodedChangeTrustOp.line = ChangeTrustAsset.decode(stream);
    decodedChangeTrustOp.limit = Int64.decode(stream);
    return decodedChangeTrustOp;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.line, this.limit);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof ChangeTrustOp)) {
      return false;
    }

    ChangeTrustOp other = (ChangeTrustOp) object;
    return Objects.equals(this.line, other.line) && Objects.equals(this.limit, other.limit);
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

  public static ChangeTrustOp fromXdrBase64(String xdr) throws IOException {
    byte[] bytes = Base64Factory.getInstance().decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static ChangeTrustOp fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }

  public static final class Builder {
    private ChangeTrustAsset line;
    private Int64 limit;

    public Builder line(ChangeTrustAsset line) {
      this.line = line;
      return this;
    }

    public Builder limit(Int64 limit) {
      this.limit = limit;
      return this;
    }

    public ChangeTrustOp build() {
      ChangeTrustOp val = new ChangeTrustOp();
      val.setLine(this.line);
      val.setLimit(this.limit);
      return val;
    }
  }
}
