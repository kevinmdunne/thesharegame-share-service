package com.thesharegame.shareservice.service;

import com.opencsv.CSVReader;
import com.thesharegame.shareservice.entity.ShareEnt;
import com.thesharegame.shareservice.repository.ShareRepository;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@Service
public class ShareService {

    private ShareRepository shareRepository;

    public ShareService(ShareRepository shareRepository){
        this.shareRepository = shareRepository;
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
