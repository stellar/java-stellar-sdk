package org.stellar.sdk.scval;

import lombok.EqualsAndHashCode;
import org.stellar.sdk.xdr.SCVal;
import org.stellar.sdk.xdr.SCValType;

/** Represents an {@link SCVal} with the type of {@link SCValType#SCV_CONTRACT_INSTANCE}. */
@EqualsAndHashCode(callSuper = false)
public class ScvContractInstance extends Scv {
  private static final SCValType TYPE = SCValType.SCV_CONTRACT_INSTANCE;

  @Override
  public SCVal toSCVal() {
    return new SCVal.Builder().discriminant(TYPE).build();
  }

  @Override
  public SCValType getSCValType() {
    return TYPE;
  }

  public static ScvContractInstance fromSCVal(SCVal scVal) {
    if (scVal.getDiscriminant() != TYPE) {
      throw new IllegalArgumentException(
          String.format(
              "invalid scVal type, expected %s, but got %s", TYPE, scVal.getDiscriminant()));
    }

    return new ScvContractInstance();
  }
}
