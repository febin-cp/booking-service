package com.sportsbooking.intdemo.Services;

import com.sportsbooking.intdemo.Modal.Modal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SportClass {

    @Autowired
    OrgsSports repository;

    public Modal saveVal(Modal modal){
        return repository.save(modal);
    }
}
