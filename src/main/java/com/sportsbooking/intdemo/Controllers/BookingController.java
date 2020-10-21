package com.sportsbooking.intdemo.Controllers;

import com.sportsbooking.intdemo.Modal.AvailableSlots;
import com.sportsbooking.intdemo.Services.CrudInterfaces.BookingImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("apis/transaction")
public class BookingController {

    @Autowired
    BookingImpl booking;

    public Optional<AvailableSlots> bookSlotById(int id){
        try{
            Optional<AvailableSlots> slots = booking.findById(id);
            return slots;
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Slot not found!");
    }
}
