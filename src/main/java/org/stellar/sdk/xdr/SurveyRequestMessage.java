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

//  struct SurveyRequestMessage
//  {
//      NodeID surveyorPeerID;
//      NodeID surveyedPeerID;
//      uint32 ledgerNum;
//      Curve25519Public encryptionKey;
//      SurveyMessageCommandType commandType;
//  };

//  ===========================================================================
public class SurveyRequestMessage implements XdrElement {
  public SurveyRequestMessage() {}

  private NodeID surveyorPeerID;

  public NodeID getSurveyorPeerID() {
    return this.surveyorPeerID;
  }

  public void setSurveyorPeerID(NodeID value) {
    this.surveyorPeerID = value;
  }

  private NodeID surveyedPeerID;

  public NodeID getSurveyedPeerID() {
    return this.surveyedPeerID;
  }

  public void setSurveyedPeerID(NodeID value) {
    this.surveyedPeerID = value;
  }

  private Uint32 ledgerNum;

  public Uint32 getLedgerNum() {
    return this.ledgerNum;
  }

  public void setLedgerNum(Uint32 value) {
    this.ledgerNum = value;
  }

  private Curve25519Public encryptionKey;

  public Curve25519Public getEncryptionKey() {
    return this.encryptionKey;
  }

  public void setEncryptionKey(Curve25519Public value) {
    this.encryptionKey = value;
  }

  private SurveyMessageCommandType commandType;

  public SurveyMessageCommandType getCommandType() {
    return this.commandType;
  }

  public void setCommandType(SurveyMessageCommandType value) {
    this.commandType = value;
  }

  public static void encode(
      XdrDataOutputStream stream, SurveyRequestMessage encodedSurveyRequestMessage)
      throws IOException {
    NodeID.encode(stream, encodedSurveyRequestMessage.surveyorPeerID);
    NodeID.encode(stream, encodedSurveyRequestMessage.surveyedPeerID);
    Uint32.encode(stream, encodedSurveyRequestMessage.ledgerNum);
    Curve25519Public.encode(stream, encodedSurveyRequestMessage.encryptionKey);
    SurveyMessageCommandType.encode(stream, encodedSurveyRequestMessage.commandType);
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static SurveyRequestMessage decode(XdrDataInputStream stream) throws IOException {
    SurveyRequestMessage decodedSurveyRequestMessage = new SurveyRequestMessage();
    decodedSurveyRequestMessage.surveyorPeerID = NodeID.decode(stream);
    decodedSurveyRequestMessage.surveyedPeerID = NodeID.decode(stream);
    decodedSurveyRequestMessage.ledgerNum = Uint32.decode(stream);
    decodedSurveyRequestMessage.encryptionKey = Curve25519Public.decode(stream);
    decodedSurveyRequestMessage.commandType = SurveyMessageCommandType.decode(stream);
    return decodedSurveyRequestMessage;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        this.surveyorPeerID,
        this.surveyedPeerID,
        this.ledgerNum,
        this.encryptionKey,
        this.commandType);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof SurveyRequestMessage)) {
      return false;
    }

    SurveyRequestMessage other = (SurveyRequestMessage) object;
    return Objects.equals(this.surveyorPeerID, other.surveyorPeerID)
        && Objects.equals(this.surveyedPeerID, other.surveyedPeerID)
        && Objects.equals(this.ledgerNum, other.ledgerNum)
        && Objects.equals(this.encryptionKey, other.encryptionKey)
        && Objects.equals(this.commandType, other.commandType);
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

  public static SurveyRequestMessage fromXdrBase64(String xdr) throws IOException {
    byte[] bytes = Base64Factory.getInstance().decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static SurveyRequestMessage fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }

  public static final class Builder {
    private NodeID surveyorPeerID;
    private NodeID surveyedPeerID;
    private Uint32 ledgerNum;
    private Curve25519Public encryptionKey;
    private SurveyMessageCommandType commandType;

    public Builder surveyorPeerID(NodeID surveyorPeerID) {
      this.surveyorPeerID = surveyorPeerID;
      return this;
    }

    public Builder surveyedPeerID(NodeID surveyedPeerID) {
      this.surveyedPeerID = surveyedPeerID;
      return this;
    }

    public Builder ledgerNum(Uint32 ledgerNum) {
      this.ledgerNum = ledgerNum;
      return this;
    }

    public Builder encryptionKey(Curve25519Public encryptionKey) {
      this.encryptionKey = encryptionKey;
      return this;
    }

    public Builder commandType(SurveyMessageCommandType commandType) {
      this.commandType = commandType;
      return this;
    }

    public SurveyRequestMessage build() {
      SurveyRequestMessage val = new SurveyRequestMessage();
      val.setSurveyorPeerID(this.surveyorPeerID);
      val.setSurveyedPeerID(this.surveyedPeerID);
      val.setLedgerNum(this.ledgerNum);
      val.setEncryptionKey(this.encryptionKey);
      val.setCommandType(this.commandType);
      return val;
    }
  }
}
