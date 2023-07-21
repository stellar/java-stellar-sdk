package org.stellar.sdk.responses.sorobanrpc;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Value;

@AllArgsConstructor
@Value
public class GetNetworkResponse {
  @SerializedName("friendbotUrl")
  String friendbotUrl;

  @SerializedName("passphrase")
  String passphrase;

  @SerializedName("protocolVersion")
  Integer protocolVersion;
}
