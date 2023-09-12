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

//  union SCEnvMetaEntry switch (SCEnvMetaKind kind)
//  {
//  case SC_ENV_META_KIND_INTERFACE_VERSION:
//      uint64 interfaceVersion;
//  };

//  ===========================================================================
public class SCEnvMetaEntry implements XdrElement {
  public SCEnvMetaEntry() {}

  SCEnvMetaKind kind;

  public SCEnvMetaKind getDiscriminant() {
    return this.kind;
  }

  public void setDiscriminant(SCEnvMetaKind value) {
    this.kind = value;
  }

  private Uint64 interfaceVersion;

  public Uint64 getInterfaceVersion() {
    return this.interfaceVersion;
  }

  public void setInterfaceVersion(Uint64 value) {
    this.interfaceVersion = value;
  }

  public static final class Builder {
    private SCEnvMetaKind discriminant;
    private Uint64 interfaceVersion;

    public Builder discriminant(SCEnvMetaKind discriminant) {
      this.discriminant = discriminant;
      return this;
    }

    public Builder interfaceVersion(Uint64 interfaceVersion) {
      this.interfaceVersion = interfaceVersion;
      return this;
    }

    public SCEnvMetaEntry build() {
      SCEnvMetaEntry val = new SCEnvMetaEntry();
      val.setDiscriminant(discriminant);
      val.setInterfaceVersion(this.interfaceVersion);
      return val;
    }
  }

  public static void encode(XdrDataOutputStream stream, SCEnvMetaEntry encodedSCEnvMetaEntry)
      throws IOException {
    // Xdrgen::AST::Identifier
    // SCEnvMetaKind
    stream.writeInt(encodedSCEnvMetaEntry.getDiscriminant().getValue());
    switch (encodedSCEnvMetaEntry.getDiscriminant()) {
      case SC_ENV_META_KIND_INTERFACE_VERSION:
        Uint64.encode(stream, encodedSCEnvMetaEntry.interfaceVersion);
        break;
    }
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static SCEnvMetaEntry decode(XdrDataInputStream stream) throws IOException {
    SCEnvMetaEntry decodedSCEnvMetaEntry = new SCEnvMetaEntry();
    SCEnvMetaKind discriminant = SCEnvMetaKind.decode(stream);
    decodedSCEnvMetaEntry.setDiscriminant(discriminant);
    switch (decodedSCEnvMetaEntry.getDiscriminant()) {
      case SC_ENV_META_KIND_INTERFACE_VERSION:
        decodedSCEnvMetaEntry.interfaceVersion = Uint64.decode(stream);
        break;
    }
    return decodedSCEnvMetaEntry;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(this.interfaceVersion, this.kind);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof SCEnvMetaEntry)) {
      return false;
    }

    SCEnvMetaEntry other = (SCEnvMetaEntry) object;
    return Objects.equal(this.interfaceVersion, other.interfaceVersion)
        && Objects.equal(this.kind, other.kind);
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

  public static SCEnvMetaEntry fromXdrBase64(String xdr) throws IOException {
    BaseEncoding base64Encoding = BaseEncoding.base64();
    byte[] bytes = base64Encoding.decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static SCEnvMetaEntry fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }
}
