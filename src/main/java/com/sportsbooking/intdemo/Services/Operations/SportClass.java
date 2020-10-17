package com.sportsbooking.intdemo.Services.Operations;

import com.sportsbooking.intdemo.Modal.Booking;
import com.sportsbooking.intdemo.Services.CrudInterfaces.BookingImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SportClass {

    @Autowired
    BookingImpl repository;

    public Booking saveVal(Booking modal){
        return repository.save(modal);
    }
}
