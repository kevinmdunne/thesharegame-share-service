package com.thesharegame.shareservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShareDto {

    private String id;
    private String symbol;
    private String fullname;
    private double price;
    private StockExchangeDto stockExchange;
}
