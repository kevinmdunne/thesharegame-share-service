package com.thesharegame.shareservice.service;

import com.opencsv.CSVReader;
import com.thesharegame.shareservice.dto.ShareDto;
import com.thesharegame.shareservice.entity.ShareEnt;
import com.thesharegame.shareservice.repository.ShareRepository;
import com.thesharegame.shareservice.util.ConvertorHelper;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;

@Service
public class ShareService {

    private ShareRepository shareRepository;

    public ShareService(ShareRepository shareRepository){
        this.shareRepository = shareRepository;
    }

    public ShareDto shareById(@Argument String id){
        Optional<ShareEnt> shareEntOptional = this.shareRepository.findById(id);
        if(shareEntOptional.isPresent()) {
            ShareEnt shareEnt = shareEntOptional.get();
            return ConvertorHelper.EntToDto(shareEnt);
        }
        return null;
    }

    public List<ShareDto> sharesByStockExchange(String stockExchangeId){
        List<ShareEnt> shares = this.shareRepository.findAllByStockExchangeId(stockExchangeId);
        return ConvertorHelper.entsToDtos(shares);
    }

    public Boolean resetShares(){
        this.shareRepository.truncateTable();
        InputStream is = ShareService.class.getResourceAsStream("/default_shares.csv");

        try (CSVReader csvReader = new CSVReader(new InputStreamReader(is))) {
            String[] values = csvReader.readNext();
            while ((values = csvReader.readNext()) != null) {
                ShareEnt shareEnt = ShareEnt.builder()
                        .symbol(values[0])
                        .fullname(values[1])
                        .price(Double.parseDouble(values[2]))
                        .stockExchangeId("cb7dfbf9-9cb2-4640-aa6a-3d5caef275e2")
                        .build();
                shareRepository.save(shareEnt);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return Boolean.TRUE;
    }
}
