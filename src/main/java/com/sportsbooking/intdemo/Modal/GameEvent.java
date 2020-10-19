package com.sportsbooking.intdemo.Modal;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "Games")
public class GameEvent {
    @Id
    @GeneratedValue
    private Integer Id;
    private String event;
    private String capacity;
    private String hoursOfOperation;
    private String hourlyRate;
}
