// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.stellar.sdk.xdr;

import static org.stellar.sdk.xdr.Constants.*;

import com.google.common.base.Objects;
import com.google.common.io.BaseEncoding;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

// === xdr source ============================================================

//  typedef uint64 Duration;

//  ===========================================================================
public class Duration implements XdrElement {
  private Uint64 Duration;

  public Duration() {}

  public Duration(Uint64 Duration) {
    this.Duration = Duration;
  }

  public Uint64 getDuration() {
    return this.Duration;
  }

  public void setDuration(Uint64 value) {
    this.Duration = value;
  }

  public static void encode(XdrDataOutputStream stream, Duration encodedDuration)
      throws IOException {
    Uint64.encode(stream, encodedDuration.Duration);
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static Duration decode(XdrDataInputStream stream) throws IOException {
    Duration decodedDuration = new Duration();
    decodedDuration.Duration = Uint64.decode(stream);
    return decodedDuration;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(this.Duration);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof Duration)) {
      return false;
    }

    Duration other = (Duration) object;
    return Objects.equal(this.Duration, other.Duration);
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

  public static Duration fromXdrBase64(String xdr) throws IOException {
    BaseEncoding base64Encoding = BaseEncoding.base64();
    byte[] bytes = base64Encoding.decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static Duration fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }
}
