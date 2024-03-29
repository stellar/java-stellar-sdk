package org.stellar.sdk.responses.sorobanrpc;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import lombok.Value;

/**
 * Response for JSON-RPC method getLedgerEntries.
 *
 * @see <a href="https://soroban.stellar.org/api/methods/getLedgerEntries#returns"
 *     target="_blank">getLedgerEntries documentation</a>
 */
@Value
public class GetLedgerEntriesResponse {
  List<LedgerEntryResult> entries;

  Long latestLedger;

  @Value
  public static class LedgerEntryResult {
    /** The field can be parsed as {@link org.stellar.sdk.xdr.LedgerKey} object. */
    String key;

    /**
     * The field can be parsed as {@link org.stellar.sdk.xdr.LedgerEntry.LedgerEntryData} object.
     */
    String xdr;

    @SerializedName("lastModifiedLedgerSeq")
    Long lastModifiedLedger;

    @SerializedName("liveUntilLedgerSeq")
    Long liveUntilLedger;
  }
}
