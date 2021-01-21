package com.sportsbooking.intdemo.Modal;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class AvailableEmployees {
    @Id
    @Column(nullable = false, unique = true)
    private Integer employeeId;
    private String slot;
    private BookingStatus status;

    public AvailableEmployees(){

    }

    public AvailableEmployees(int employeeId, String slot, BookingStatus status){
        this.employeeId = employeeId;
        this.slot = slot;
        this.status = status;
    }
}
