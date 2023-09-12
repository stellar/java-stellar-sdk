// Automatically generated by xdrgen
// DO NOT EDIT or your changes may be overwritten

package org.stellar.sdk.xdr;

import static org.stellar.sdk.xdr.Constants.*;

import com.google.common.base.Objects;
import com.google.common.io.BaseEncoding;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

// === xdr source ============================================================

//  struct TransactionSetV1
//  {
//      Hash previousLedgerHash;
//      TransactionPhase phases<>;
//  };

//  ===========================================================================
public class TransactionSetV1 implements XdrElement {
  public TransactionSetV1() {}

  private Hash previousLedgerHash;

  public Hash getPreviousLedgerHash() {
    return this.previousLedgerHash;
  }

  public void setPreviousLedgerHash(Hash value) {
    this.previousLedgerHash = value;
  }

  private TransactionPhase[] phases;

  public TransactionPhase[] getPhases() {
    return this.phases;
  }

  public void setPhases(TransactionPhase[] value) {
    this.phases = value;
  }

  public static void encode(XdrDataOutputStream stream, TransactionSetV1 encodedTransactionSetV1)
      throws IOException {
    Hash.encode(stream, encodedTransactionSetV1.previousLedgerHash);
    int phasessize = encodedTransactionSetV1.getPhases().length;
    stream.writeInt(phasessize);
    for (int i = 0; i < phasessize; i++) {
      TransactionPhase.encode(stream, encodedTransactionSetV1.phases[i]);
    }
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static TransactionSetV1 decode(XdrDataInputStream stream) throws IOException {
    TransactionSetV1 decodedTransactionSetV1 = new TransactionSetV1();
    decodedTransactionSetV1.previousLedgerHash = Hash.decode(stream);
    int phasessize = stream.readInt();
    decodedTransactionSetV1.phases = new TransactionPhase[phasessize];
    for (int i = 0; i < phasessize; i++) {
      decodedTransactionSetV1.phases[i] = TransactionPhase.decode(stream);
    }
    return decodedTransactionSetV1;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(this.previousLedgerHash, Arrays.hashCode(this.phases));
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof TransactionSetV1)) {
      return false;
    }

    TransactionSetV1 other = (TransactionSetV1) object;
    return Objects.equal(this.previousLedgerHash, other.previousLedgerHash)
        && Arrays.equals(this.phases, other.phases);
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

  public static TransactionSetV1 fromXdrBase64(String xdr) throws IOException {
    BaseEncoding base64Encoding = BaseEncoding.base64();
    byte[] bytes = base64Encoding.decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static TransactionSetV1 fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }

  public static final class Builder {
    private Hash previousLedgerHash;
    private TransactionPhase[] phases;

    public Builder previousLedgerHash(Hash previousLedgerHash) {
      this.previousLedgerHash = previousLedgerHash;
      return this;
    }

    public Builder phases(TransactionPhase[] phases) {
      this.phases = phases;
      return this;
    }

    public TransactionSetV1 build() {
      TransactionSetV1 val = new TransactionSetV1();
      val.setPreviousLedgerHash(this.previousLedgerHash);
      val.setPhases(this.phases);
      return val;
    }
  }
}
