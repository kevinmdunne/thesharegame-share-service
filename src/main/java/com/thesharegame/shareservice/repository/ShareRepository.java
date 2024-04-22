package com.thesharegame.shareservice.repository;

import com.thesharegame.shareservice.entity.ShareEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ShareRepository extends JpaRepository<ShareEnt, String> {

    List<ShareEnt> findAllByStockExchangeId(String stockExchangeId);

    @Modifying
    @Transactional
    @Query(value = "TRUNCATE TABLE shares", nativeQuery = true)
    void truncateTable();

}
