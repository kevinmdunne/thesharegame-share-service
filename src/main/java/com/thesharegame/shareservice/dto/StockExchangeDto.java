package com.thesharegame.shareservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StockExchangeDto {

    private String id;
    private String symbol;
    private String fullname;

}
