// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.stellar.sdk.xdr;

import java.io.IOException;
import java.util.Arrays;

// === xdr source ============================================================

//  typedef opaque Signature<64>;

//  ===========================================================================
public class Signature implements XdrElement {
  private byte[] Signature;

  public Signature() {}

  public Signature(byte[] Signature) {
    this.Signature = Signature;
  }

  public byte[] getSignature() {
    return this.Signature;
  }

  public void setSignature(byte[] value) {
    this.Signature = value;
  }

  public static void encode(XdrDataOutputStream stream, Signature encodedSignature)
      throws IOException {
    int Signaturesize = encodedSignature.Signature.length;
    stream.writeInt(Signaturesize);
    stream.write(encodedSignature.getSignature(), 0, Signaturesize);
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static Signature decode(XdrDataInputStream stream) throws IOException {
    Signature decodedSignature = new Signature();
    int Signaturesize = stream.readInt();
    decodedSignature.Signature = new byte[Signaturesize];
    stream.read(decodedSignature.Signature, 0, Signaturesize);
    return decodedSignature;
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(this.Signature);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof Signature)) {
      return false;
    }

    Signature other = (Signature) object;
    return Arrays.equals(this.Signature, other.Signature);
  }
}
