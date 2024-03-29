package org.stellar.sdk;

import com.google.gson.annotations.SerializedName;
import lombok.Value;

/** Represents an amount of asset. */
@Value
public class AssetAmount {
  /*
   * The asset.
   */
  @SerializedName("asset")
  Asset asset;

  /*
   * The amount.
   */
  @SerializedName("amount")
  String amount;
}
