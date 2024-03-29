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

//  struct SCSpecFunctionV0
//  {
//      string doc<SC_SPEC_DOC_LIMIT>;
//      SCSymbol name;
//      SCSpecFunctionInputV0 inputs<10>;
//      SCSpecTypeDef outputs<1>;
//  };

//  ===========================================================================
public class SCSpecFunctionV0 implements XdrElement {
  public SCSpecFunctionV0() {}

  private XdrString doc;

  public XdrString getDoc() {
    return this.doc;
  }

  public void setDoc(XdrString value) {
    this.doc = value;
  }

  private SCSymbol name;

  public SCSymbol getName() {
    return this.name;
  }

  public void setName(SCSymbol value) {
    this.name = value;
  }

  private SCSpecFunctionInputV0[] inputs;

  public SCSpecFunctionInputV0[] getInputs() {
    return this.inputs;
  }

  public void setInputs(SCSpecFunctionInputV0[] value) {
    this.inputs = value;
  }

  private SCSpecTypeDef[] outputs;

  public SCSpecTypeDef[] getOutputs() {
    return this.outputs;
  }

  public void setOutputs(SCSpecTypeDef[] value) {
    this.outputs = value;
  }

  public static void encode(XdrDataOutputStream stream, SCSpecFunctionV0 encodedSCSpecFunctionV0)
      throws IOException {
    encodedSCSpecFunctionV0.doc.encode(stream);
    SCSymbol.encode(stream, encodedSCSpecFunctionV0.name);
    int inputssize = encodedSCSpecFunctionV0.getInputs().length;
    stream.writeInt(inputssize);
    for (int i = 0; i < inputssize; i++) {
      SCSpecFunctionInputV0.encode(stream, encodedSCSpecFunctionV0.inputs[i]);
    }
    int outputssize = encodedSCSpecFunctionV0.getOutputs().length;
    stream.writeInt(outputssize);
    for (int i = 0; i < outputssize; i++) {
      SCSpecTypeDef.encode(stream, encodedSCSpecFunctionV0.outputs[i]);
    }
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static SCSpecFunctionV0 decode(XdrDataInputStream stream) throws IOException {
    SCSpecFunctionV0 decodedSCSpecFunctionV0 = new SCSpecFunctionV0();
    decodedSCSpecFunctionV0.doc = XdrString.decode(stream, SC_SPEC_DOC_LIMIT);
    decodedSCSpecFunctionV0.name = SCSymbol.decode(stream);
    int inputssize = stream.readInt();
    decodedSCSpecFunctionV0.inputs = new SCSpecFunctionInputV0[inputssize];
    for (int i = 0; i < inputssize; i++) {
      decodedSCSpecFunctionV0.inputs[i] = SCSpecFunctionInputV0.decode(stream);
    }
    int outputssize = stream.readInt();
    decodedSCSpecFunctionV0.outputs = new SCSpecTypeDef[outputssize];
    for (int i = 0; i < outputssize; i++) {
      decodedSCSpecFunctionV0.outputs[i] = SCSpecTypeDef.decode(stream);
    }
    return decodedSCSpecFunctionV0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        this.doc, this.name, Arrays.hashCode(this.inputs), Arrays.hashCode(this.outputs));
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof SCSpecFunctionV0)) {
      return false;
    }

    SCSpecFunctionV0 other = (SCSpecFunctionV0) object;
    return Objects.equals(this.doc, other.doc)
        && Objects.equals(this.name, other.name)
        && Arrays.equals(this.inputs, other.inputs)
        && Arrays.equals(this.outputs, other.outputs);
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

  public static SCSpecFunctionV0 fromXdrBase64(String xdr) throws IOException {
    byte[] bytes = Base64Factory.getInstance().decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static SCSpecFunctionV0 fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }

  public static final class Builder {
    private XdrString doc;
    private SCSymbol name;
    private SCSpecFunctionInputV0[] inputs;
    private SCSpecTypeDef[] outputs;

    public Builder doc(XdrString doc) {
      this.doc = doc;
      return this;
    }

    public Builder name(SCSymbol name) {
      this.name = name;
      return this;
    }

    public Builder inputs(SCSpecFunctionInputV0[] inputs) {
      this.inputs = inputs;
      return this;
    }

    public Builder outputs(SCSpecTypeDef[] outputs) {
      this.outputs = outputs;
      return this;
    }

    public SCSpecFunctionV0 build() {
      SCSpecFunctionV0 val = new SCSpecFunctionV0();
      val.setDoc(this.doc);
      val.setName(this.name);
      val.setInputs(this.inputs);
      val.setOutputs(this.outputs);
      return val;
    }
  }
}
