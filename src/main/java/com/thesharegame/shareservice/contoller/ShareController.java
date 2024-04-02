package com.thesharegame.shareservice.contoller;

import com.thesharegame.shareservice.dto.ShareDto;
import com.thesharegame.shareservice.dto.StockExchangeDto;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("share")
public class ShareController {

    @QueryMapping
    public ShareDto shareById(@Argument String id){
        StockExchangeDto se = StockExchangeDto.builder()
                .id("XXX")
                .fullname("ExchangeMe")
                .symbol("SYM")
                .build();
        return ShareDto.builder()
                .id(id)
                .fullname("Kevin")
                .symbol("KEV")
                .stockExchange(se)
                .build();

    }
}
