package com.sportsbooking.intdemo.Services;

import com.sportsbooking.intdemo.Modal.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SportClass {

    @Autowired
    OrgsSports repository;

    public Booking saveVal(Booking modal){
        return repository.save(modal);
    }
}
