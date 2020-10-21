package com.sportsbooking.intdemo.Modal;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class AvailableSlots {
    @Id
    @GeneratedValue
    private Integer id;
    private String slot;
    private String status;

    public AvailableSlots(){

    }

    public  AvailableSlots(String slot, String status){
        this.slot = slot;
        this.status = status;
    }
}
