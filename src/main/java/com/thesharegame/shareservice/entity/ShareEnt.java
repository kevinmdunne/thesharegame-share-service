package com.thesharegame.shareservice.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name="shares")
@Data
@Builder
public class ShareEnt {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private String id;

    @Column(name="symbol", length=20, nullable=false)
    private String symbol;

    @Column(name="fullname", nullable=false)
    private String fullname;

    @Column(name="price", nullable=false)
    private double price;

    @Column(name="stock_exchange_id", nullable=false)
    private String stockExchangeId;

}
