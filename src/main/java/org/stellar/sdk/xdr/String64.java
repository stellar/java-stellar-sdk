// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.stellar.sdk.xdr;


import java.io.IOException;

import java.util.Arrays;

// === xdr source ============================================================

//  typedef string string64<64>;

//  ===========================================================================
public class String64 implements XdrElement {
  private byte[] string64;
  public byte[] getString64() {
    return this.string64;
  }
  public void setString64(byte[] value) {
    this.string64 = value;
  }
  public static void encode(XdrDataOutputStream stream, String64  encodedString64) throws IOException {
  int string64size = encodedString64.string64.length;
  stream.writeInt(string64size);
  stream.write(encodedString64.getString64(), 0, string64size);
  }
  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }
  public static String64 decode(XdrDataInputStream stream) throws IOException {
    String64 decodedString64 = new String64();
  int string64size = stream.readInt();
  decodedString64.string64 = new byte[string64size];
  stream.read(decodedString64.string64, 0, string64size);
    return decodedString64;
  }
  @Override
  public int hashCode() {
    return Arrays.hashCode(this.string64);
  }
  @Override
  public boolean equals(Object object) {
    if (object == null || !(object instanceof String64)) {
      return false;
    }

    String64 other = (String64) object;
    return Arrays.equals(this.string64, other.string64);
  }
}
