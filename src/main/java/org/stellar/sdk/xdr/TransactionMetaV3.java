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

//  struct TransactionMetaV3
//  {
//      ExtensionPoint ext;
//
//      LedgerEntryChanges txChangesBefore;  // tx level changes before operations
//                                           // are applied if any
//      OperationMeta operations<>;          // meta for each operation
//      LedgerEntryChanges txChangesAfter;   // tx level changes after operations are
//                                           // applied if any
//      SorobanTransactionMeta* sorobanMeta; // Soroban-specific meta (only for
//                                           // Soroban transactions).
//  };

//  ===========================================================================
public class TransactionMetaV3 implements XdrElement {
  public TransactionMetaV3() {}

  private ExtensionPoint ext;

  public ExtensionPoint getExt() {
    return this.ext;
  }

  public void setExt(ExtensionPoint value) {
    this.ext = value;
  }

  private LedgerEntryChanges txChangesBefore;

  public LedgerEntryChanges getTxChangesBefore() {
    return this.txChangesBefore;
  }

  public void setTxChangesBefore(LedgerEntryChanges value) {
    this.txChangesBefore = value;
  }

  private OperationMeta[] operations;

  public OperationMeta[] getOperations() {
    return this.operations;
  }

  public void setOperations(OperationMeta[] value) {
    this.operations = value;
  }

  private LedgerEntryChanges txChangesAfter;

  public LedgerEntryChanges getTxChangesAfter() {
    return this.txChangesAfter;
  }

  public void setTxChangesAfter(LedgerEntryChanges value) {
    this.txChangesAfter = value;
  }

  private SorobanTransactionMeta sorobanMeta;

  public SorobanTransactionMeta getSorobanMeta() {
    return this.sorobanMeta;
  }

  public void setSorobanMeta(SorobanTransactionMeta value) {
    this.sorobanMeta = value;
  }

  public static void encode(XdrDataOutputStream stream, TransactionMetaV3 encodedTransactionMetaV3)
      throws IOException {
    ExtensionPoint.encode(stream, encodedTransactionMetaV3.ext);
    LedgerEntryChanges.encode(stream, encodedTransactionMetaV3.txChangesBefore);
    int operationssize = encodedTransactionMetaV3.getOperations().length;
    stream.writeInt(operationssize);
    for (int i = 0; i < operationssize; i++) {
      OperationMeta.encode(stream, encodedTransactionMetaV3.operations[i]);
    }
    LedgerEntryChanges.encode(stream, encodedTransactionMetaV3.txChangesAfter);
    if (encodedTransactionMetaV3.sorobanMeta != null) {
      stream.writeInt(1);
      SorobanTransactionMeta.encode(stream, encodedTransactionMetaV3.sorobanMeta);
    } else {
      stream.writeInt(0);
    }
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static TransactionMetaV3 decode(XdrDataInputStream stream) throws IOException {
    TransactionMetaV3 decodedTransactionMetaV3 = new TransactionMetaV3();
    decodedTransactionMetaV3.ext = ExtensionPoint.decode(stream);
    decodedTransactionMetaV3.txChangesBefore = LedgerEntryChanges.decode(stream);
    int operationssize = stream.readInt();
    decodedTransactionMetaV3.operations = new OperationMeta[operationssize];
    for (int i = 0; i < operationssize; i++) {
      decodedTransactionMetaV3.operations[i] = OperationMeta.decode(stream);
    }
    decodedTransactionMetaV3.txChangesAfter = LedgerEntryChanges.decode(stream);
    int sorobanMetaPresent = stream.readInt();
    if (sorobanMetaPresent != 0) {
      decodedTransactionMetaV3.sorobanMeta = SorobanTransactionMeta.decode(stream);
    }
    return decodedTransactionMetaV3;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        this.ext,
        this.txChangesBefore,
        Arrays.hashCode(this.operations),
        this.txChangesAfter,
        this.sorobanMeta);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof TransactionMetaV3)) {
      return false;
    }

    TransactionMetaV3 other = (TransactionMetaV3) object;
    return Objects.equals(this.ext, other.ext)
        && Objects.equals(this.txChangesBefore, other.txChangesBefore)
        && Arrays.equals(this.operations, other.operations)
        && Objects.equals(this.txChangesAfter, other.txChangesAfter)
        && Objects.equals(this.sorobanMeta, other.sorobanMeta);
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

  public static TransactionMetaV3 fromXdrBase64(String xdr) throws IOException {
    byte[] bytes = Base64Factory.getInstance().decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static TransactionMetaV3 fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }

  public static final class Builder {
    private ExtensionPoint ext;
    private LedgerEntryChanges txChangesBefore;
    private OperationMeta[] operations;
    private LedgerEntryChanges txChangesAfter;
    private SorobanTransactionMeta sorobanMeta;

    public Builder ext(ExtensionPoint ext) {
      this.ext = ext;
      return this;
    }

    public Builder txChangesBefore(LedgerEntryChanges txChangesBefore) {
      this.txChangesBefore = txChangesBefore;
      return this;
    }

    public Builder operations(OperationMeta[] operations) {
      this.operations = operations;
      return this;
    }

    public Builder txChangesAfter(LedgerEntryChanges txChangesAfter) {
      this.txChangesAfter = txChangesAfter;
      return this;
    }

    public Builder sorobanMeta(SorobanTransactionMeta sorobanMeta) {
      this.sorobanMeta = sorobanMeta;
      return this;
    }

    public TransactionMetaV3 build() {
      TransactionMetaV3 val = new TransactionMetaV3();
      val.setExt(this.ext);
      val.setTxChangesBefore(this.txChangesBefore);
      val.setOperations(this.operations);
      val.setTxChangesAfter(this.txChangesAfter);
      val.setSorobanMeta(this.sorobanMeta);
      return val;
    }
  }
}
