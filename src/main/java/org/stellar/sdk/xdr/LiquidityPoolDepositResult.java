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

//  union LiquidityPoolDepositResult switch (LiquidityPoolDepositResultCode code)
//  {
//  case LIQUIDITY_POOL_DEPOSIT_SUCCESS:
//      void;
//  case LIQUIDITY_POOL_DEPOSIT_MALFORMED:
//  case LIQUIDITY_POOL_DEPOSIT_NO_TRUST:
//  case LIQUIDITY_POOL_DEPOSIT_NOT_AUTHORIZED:
//  case LIQUIDITY_POOL_DEPOSIT_UNDERFUNDED:
//  case LIQUIDITY_POOL_DEPOSIT_LINE_FULL:
//  case LIQUIDITY_POOL_DEPOSIT_BAD_PRICE:
//  case LIQUIDITY_POOL_DEPOSIT_POOL_FULL:
//      void;
//  };

//  ===========================================================================
public class LiquidityPoolDepositResult implements XdrElement {
  public LiquidityPoolDepositResult() {}

  LiquidityPoolDepositResultCode code;

  public LiquidityPoolDepositResultCode getDiscriminant() {
    return this.code;
  }

  public void setDiscriminant(LiquidityPoolDepositResultCode value) {
    this.code = value;
  }

  public static final class Builder {
    private LiquidityPoolDepositResultCode discriminant;

    public Builder discriminant(LiquidityPoolDepositResultCode discriminant) {
      this.discriminant = discriminant;
      return this;
    }

    public LiquidityPoolDepositResult build() {
      LiquidityPoolDepositResult val = new LiquidityPoolDepositResult();
      val.setDiscriminant(discriminant);
      return val;
    }
  }

  public static void encode(
      XdrDataOutputStream stream, LiquidityPoolDepositResult encodedLiquidityPoolDepositResult)
      throws IOException {
    // Xdrgen::AST::Identifier
    // LiquidityPoolDepositResultCode
    stream.writeInt(encodedLiquidityPoolDepositResult.getDiscriminant().getValue());
    switch (encodedLiquidityPoolDepositResult.getDiscriminant()) {
      case LIQUIDITY_POOL_DEPOSIT_SUCCESS:
        break;
      case LIQUIDITY_POOL_DEPOSIT_MALFORMED:
      case LIQUIDITY_POOL_DEPOSIT_NO_TRUST:
      case LIQUIDITY_POOL_DEPOSIT_NOT_AUTHORIZED:
      case LIQUIDITY_POOL_DEPOSIT_UNDERFUNDED:
      case LIQUIDITY_POOL_DEPOSIT_LINE_FULL:
      case LIQUIDITY_POOL_DEPOSIT_BAD_PRICE:
      case LIQUIDITY_POOL_DEPOSIT_POOL_FULL:
        break;
    }
  }

  public void encode(XdrDataOutputStream stream) throws IOException {
    encode(stream, this);
  }

  public static LiquidityPoolDepositResult decode(XdrDataInputStream stream) throws IOException {
    LiquidityPoolDepositResult decodedLiquidityPoolDepositResult = new LiquidityPoolDepositResult();
    LiquidityPoolDepositResultCode discriminant = LiquidityPoolDepositResultCode.decode(stream);
    decodedLiquidityPoolDepositResult.setDiscriminant(discriminant);
    switch (decodedLiquidityPoolDepositResult.getDiscriminant()) {
      case LIQUIDITY_POOL_DEPOSIT_SUCCESS:
        break;
      case LIQUIDITY_POOL_DEPOSIT_MALFORMED:
      case LIQUIDITY_POOL_DEPOSIT_NO_TRUST:
      case LIQUIDITY_POOL_DEPOSIT_NOT_AUTHORIZED:
      case LIQUIDITY_POOL_DEPOSIT_UNDERFUNDED:
      case LIQUIDITY_POOL_DEPOSIT_LINE_FULL:
      case LIQUIDITY_POOL_DEPOSIT_BAD_PRICE:
      case LIQUIDITY_POOL_DEPOSIT_POOL_FULL:
        break;
    }
    return decodedLiquidityPoolDepositResult;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.code);
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof LiquidityPoolDepositResult)) {
      return false;
    }

    LiquidityPoolDepositResult other = (LiquidityPoolDepositResult) object;
    return Objects.equals(this.code, other.code);
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

  public static LiquidityPoolDepositResult fromXdrBase64(String xdr) throws IOException {
    byte[] bytes = Base64Factory.getInstance().decode(xdr);
    return fromXdrByteArray(bytes);
  }

  public static LiquidityPoolDepositResult fromXdrByteArray(byte[] xdr) throws IOException {
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xdr);
    XdrDataInputStream xdrDataInputStream = new XdrDataInputStream(byteArrayInputStream);
    return decode(xdrDataInputStream);
  }
}
