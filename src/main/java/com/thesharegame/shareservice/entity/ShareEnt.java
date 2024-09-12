package com.thesharegame.shareservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.Instant;

@Entity
@Table(name="shares")
@Data
@Builder
@AllArgsConstructor
public class ShareEnt {

    public ShareEnt(){}

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

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Instant createDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modify_date")
    private Instant modifyDate;

}
