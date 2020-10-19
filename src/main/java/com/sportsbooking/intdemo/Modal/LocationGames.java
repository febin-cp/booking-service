package com.sportsbooking.intdemo.Modal;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "GameList")
public class LocationGames {
    @Id
    @GeneratedValue
    private Integer Id;
    private String merchantId;
    private String gameEvent;
    private String capacity;
    private String hoursOfOperation;
    private String hourlyRate;
}
