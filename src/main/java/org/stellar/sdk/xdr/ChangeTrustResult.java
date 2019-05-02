// Automatically generated by xdrgen 
// DO NOT EDIT or your changes may be overwritten

package org.stellar.sdk.xdr;


import java.io.IOException;

// === xdr source ============================================================

//  union ChangeTrustResult switch (ChangeTrustResultCode code)
//  {
//  case CHANGE_TRUST_SUCCESS:
//      void;
//  default:
//      void;
//  };

//  ===========================================================================
public class ChangeTrustResult  {
  public ChangeTrustResult () {}
  ChangeTrustResultCode code;
  public ChangeTrustResultCode getDiscriminant() {
    return this.code;
  }
  public void setDiscriminant(ChangeTrustResultCode value) {
    this.code = value;
  }
  public static void encode(XdrDataOutputStream stream, ChangeTrustResult encodedChangeTrustResult) throws IOException {
  //Xdrgen::AST::Identifier
  //ChangeTrustResultCode
  stream.writeInt(encodedChangeTrustResult.getDiscriminant().getValue());
  switch (encodedChangeTrustResult.getDiscriminant()) {
  case CHANGE_TRUST_SUCCESS:
  break;
  default:
  break;
  }
  }
  public static ChangeTrustResult decode(XdrDataInputStream stream) throws IOException {
  ChangeTrustResult decodedChangeTrustResult = new ChangeTrustResult();
  ChangeTrustResultCode discriminant = ChangeTrustResultCode.decode(stream);
  decodedChangeTrustResult.setDiscriminant(discriminant);
  switch (decodedChangeTrustResult.getDiscriminant()) {
  case CHANGE_TRUST_SUCCESS:
  break;
  default:
  break;
  }
    return decodedChangeTrustResult;
  }
}
