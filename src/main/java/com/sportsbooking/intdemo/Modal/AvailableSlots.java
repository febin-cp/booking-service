package com.sportsbooking.intdemo.Modal;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class AvailableSlots {
    @Id
    @Column(nullable = false, unique = true)
    private Integer id;
    private String slot;
    private BookingStatus status;

    public AvailableSlots(){

    }

    public  AvailableSlots(int id,String slot, BookingStatus status){
        this.id = id;
        this.slot = slot;
        this.status = status;
    }
}
