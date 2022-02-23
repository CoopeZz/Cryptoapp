
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
    "timestamp",
    "error_code",
    "error_message",
    "elapsed",
    "credit_count",
    "notice"
})
public class Status {

    @JsonProperty("timestamp")
    public String timestamp;
    @JsonProperty("error_code")
    public Integer errorCode;
    @JsonProperty("error_message")
    public Object errorMessage;
    @JsonProperty("elapsed")
    public Integer elapsed;
    @JsonProperty("credit_count")
    public Integer creditCount;
    @JsonProperty("notice")
    public Object notice;
}
