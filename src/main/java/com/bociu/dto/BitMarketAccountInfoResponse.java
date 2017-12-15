package com.bociu.dto;

import java.math.BigDecimal;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BitMarketAccountInfoResponse extends BitMarketResponse<BitMarketAccountInfo> {

    public BitMarketAccountInfoResponse(@JsonProperty("success") boolean success, @JsonProperty("data") BitMarketAccountInfo value,
                                        @JsonProperty("time") Long time, @JsonProperty("limit") Map<String, BigDecimal> limit) {
        super(success, value, time, limit);
    }

}