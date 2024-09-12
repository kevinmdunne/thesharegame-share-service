package com.thesharegame.shareservice.dto;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class StockExchangeDto {

    private String id;
    private String symbol;
    private String fullname;
    private Instant createDate;
    private Instant modifyDate;
}
