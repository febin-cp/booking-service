package com.sportsbooking.intdemo.Modal;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "Payments")
public class Payment {
    @Id
    @GeneratedValue
    private Integer Id;
    private String locationId;
    private Integer hours;
    private String gameEvent;
    private float amount;
}
