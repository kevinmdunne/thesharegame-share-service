package com.thesharegame.shareservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name="stockexchanges")
@Data
@Builder
public class StockExchangeEnt {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private String id;

    @Column(name="symbol", length=20, nullable=false)
    private String symbol;

    @Column(name="fullname", length=200, nullable=false)
    private String fullname;
}
