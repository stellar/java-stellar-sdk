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

//  union HostFunction switch (HostFunctionType type)
//  {
//  case HOST_FUNCTION_TYPE_INVOKE_CONTRACT:
//      SCVec invokeContract;
//  case HOST_FUNCTION_TYPE_CREATE_CONTRACT:
//      CreateContractArgs createContract;
//  case HOST_FUNCTION_TYPE_UPLOAD_CONTRACT_WASM:
//      opaque wasm<>;
//  };

//  ===========================================================================
public class HostFunction implements XdrElement {
  public HostFunction() {}

  HostFunctionType type;

  public HostFunctionType getDiscriminant() {
    return this.type;
  }

  public void setDiscriminant(HostFunctionType value) {
    this.type = value;
  }

  private SCVec invokeContract;

  public SCVec getInvokeContract() {
    return this.invokeContract;
  }

  public void setInvokeContract(SCVec value) {
    this.invokeContract = value;
  }

  private CreateContractArgs createContract;

  public CreateContractArgs getCreateContract() {
    return this.createContract;
  }

  public void setCreateContract(CreateContractArgs value) {
    this.createContract = value;
  }

  private byte[] wasm;

  public byte[] getWasm() {
    return this.wasm;
  }

  public void setWasm(byte[] value) {
    this.wasm = value;
  }

  public static final class Builder {
    private HostFunctionType discriminant;
    private SCVec invokeContract;
    private CreateContractArgs createContract;
    private byte[] wasm;

    public Builder discriminant(HostFunctionType discriminant) {
      this.discriminant = discriminant;
      return this;
    }

    public Builder invokeContract(SCVec invokeContract) {
      this.invokeContract = invokeContract;
      return this;
    }

    public Builder createContract(CreateContractArgs createContract) {
      this.createContract = createContract;
      return this;
    }

    public Builder wasm(byte[] wasm) {
      this.wasm = wasm;
      return this;
    }

    public HostFunction build() {
      HostFunction val = new HostFunction();
      val.setDiscriminant(discriminant);
      val.setInvokeContract(this.invokeContract);
      val.setCreateContract(this.createContract);
      val.setWasm(this.wasm);
      return val;
    }
  }

  public static void encode(XdrDataOutputStream stream, HostFunction encodedHostFunction)
      throws IOException {
    // Xdrgen::AST::Identifier
    // HostFunctionType
    stream.writeInt(encodedHostFunction.getDiscriminant().getValue());
    switch (encodedHostFunction.getDiscriminant()) {
      case HOST_FUNCTION_TYPE_INVOKE_CONTRACT:
        SCVec.encode(stream, encodedHostFunction.invokeContract);
        break;
      case HOST_FUNCTION_TYPE_CREATE_CONTRACT:
        CreateContractArgs.encode(stream, encodedHostFunction.createContract);
        break;
      case HOST_FUNCTION_TYPE_UPLOAD_CONTRACT_WASM:
        int wasmsize = encodedHostFunction.wasm.length;
        stream.writeInt(wasmsize);
        stream.write(encodedHostFunction.getWasm(), 0, wasmsize);
        break;
    }
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static HostFunction decode(XdrDataInputStream stream) throws IOException {
    HostFunction decodedHostFunction = new HostFunction();
    HostFunctionType discriminant = HostFunctionType.decode(stream);
    decodedHostFunction.setDiscriminant(discriminant);
    switch (decodedHostFunction.getDiscriminant()) {
      case HOST_FUNCTION_TYPE_INVOKE_CONTRACT:
        decodedHostFunction.invokeContract = SCVec.decode(stream);
        break;
      case HOST_FUNCTION_TYPE_CREATE_CONTRACT:
        decodedHostFunction.createContract = CreateContractArgs.decode(stream);
        break;
      case HOST_FUNCTION_TYPE_UPLOAD_CONTRACT_WASM:
        int wasmsize = stream.readInt();
        decodedHostFunction.wasm = new byte[wasmsize];
        stream.read(decodedHostFunction.wasm, 0, wasmsize);
        break;
    }
    return decodedHostFunction;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(
        this.invokeContract, this.createContract, Arrays.hashCode(this.wasm), this.type);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof HostFunction)) {
      return false;
    }

    HostFunction other = (HostFunction) object;
    return Objects.equal(this.invokeContract, other.invokeContract)
        && Objects.equal(this.createContract, other.createContract)
        && Arrays.equals(this.wasm, other.wasm)
        && Objects.equal(this.type, other.type);
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

  public static HostFunction fromXdrBase64(String xdr) throws IOException {
    BaseEncoding base64Encoding = BaseEncoding.base64();
    byte[] bytes = base64Encoding.decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static HostFunction fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }
}