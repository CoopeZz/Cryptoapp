
package com.example.cryptoapp.model.response;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "symbol",
    "slug",
    "num_market_pairs",
    "date_added",
    "max_supply",
    "circulating_supply",
    "total_supply",
    "is_active",
    "platform",
    "cmc_rank",
    "is_fiat",
    "self_reported_circulating_supply",
    "self_reported_market_cap",
    "last_updated",
    "quote"
})
public class Id {

    @JsonProperty("id")
    public Integer id;
    @JsonProperty("name")
    public String name;
    @JsonProperty("symbol")
    public String symbol;
    @JsonProperty("slug")
    public String slug;
    @JsonProperty("num_market_pairs")
    public Integer numMarketPairs;
    @JsonProperty("date_added")
    public String dateAdded;
    @JsonProperty("max_supply")
    public Integer maxSupply;
    @JsonProperty("circulating_supply")
    public Integer circulatingSupply;
    @JsonProperty("total_supply")
    public Integer totalSupply;
    @JsonProperty("is_active")
    public Integer isActive;
    @JsonProperty("platform")
    public Object platform;
    @JsonProperty("cmc_rank")
    public Integer cmcRank;
    @JsonProperty("is_fiat")
    public Integer isFiat;
    @JsonProperty("self_reported_circulating_supply")
    public Object selfReportedCirculatingSupply;
    @JsonProperty("self_reported_market_cap")
    public Object selfReportedMarketCap;
    @JsonProperty("last_updated")
    public String lastUpdated;
    @JsonProperty("quote")
    public Quote quote;
}
