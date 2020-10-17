package com.sportsbooking.intdemo.Modal;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "Booking")
public class Booking {
    @Id
    @GeneratedValue
    private Integer Id;
    private String gameEvent;
    private String locationId;
    private Integer noOfCourts;
    private Integer hoursRequired;
    private float totalAmount;
}
