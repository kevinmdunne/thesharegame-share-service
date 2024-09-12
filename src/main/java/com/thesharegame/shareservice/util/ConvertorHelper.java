package com.thesharegame.shareservice.util;

import com.thesharegame.shareservice.dto.ShareDto;
import com.thesharegame.shareservice.entity.ShareEnt;

import java.util.ArrayList;
import java.util.List;

public class ConvertorHelper {

    public static ShareDto EntToDto(ShareEnt shareEnt){
        return ShareDto.builder()
                .id(shareEnt.getId())
                .symbol(shareEnt.getSymbol())
                .price(shareEnt.getPrice())
                .fullname(shareEnt.getFullname())
                .createDate(shareEnt.getCreateDate())
                .modifyDate(shareEnt.getModifyDate())
                .build();
    }

    public static List<ShareDto> entsToDtos(List<ShareEnt> shareEnts){
        List<ShareDto> dtos = new ArrayList<>();
        for(ShareEnt shareEnt : shareEnts){
            dtos.add(ConvertorHelper.EntToDto(shareEnt));
        }
        return dtos;
    }
}
