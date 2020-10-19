package com.sportsbooking.intdemo.Modal;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "merchant")
public class Merchant {
    @GeneratedValue
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Location")
    private String location;
    @Column(name = "MerchantName")
    private String merchantName;
    @Id
    @Column(name = "MerchantId")
    private String merchantId;
}
