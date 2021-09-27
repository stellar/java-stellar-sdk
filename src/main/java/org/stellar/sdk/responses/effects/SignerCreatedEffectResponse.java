package org.stellar.sdk.responses.effects;

/**
 * Represents signer_created effect response.
 * @see <a href="https://developers.stellar.org/api/resources/effects/" target="_blank">Effect documentation</a>
 * @see org.stellar.sdk.requests.EffectsRequestBuilder
 * @see org.stellar.sdk.Server#effects()
 */
public class SignerCreatedEffectResponse extends SignerEffectResponse {
  SignerCreatedEffectResponse(Integer weight, String publicKey) {
    super(weight, publicKey);
  }
}
