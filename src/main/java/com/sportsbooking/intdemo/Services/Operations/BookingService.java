package com.sportsbooking.intdemo.Services.Operations;

import com.sportsbooking.intdemo.Modal.AvailableSlots;
import com.sportsbooking.intdemo.Modal.BookingStatus;
import com.sportsbooking.intdemo.Services.CrudInterfaces.BookingImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    BookingImpl booking;

    public boolean findAndBookSlot(int id) {
        Optional<AvailableSlots> slot = booking.findById(id);
        System.out.println("Slot fetched" + slot);
        if (slot.isPresent()) {
            AvailableSlots updateSlot = slot.get();
            if (updateSlot.getStatus().equals(BookingStatus.AVAILABLE)) {
                updateSlot.setStatus(BookingStatus.NOT_AVAILABLE);
                booking.save(updateSlot);
                return true;
            }  else{
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Slot is already booked");
            }
        } else {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "No such slot available");
        }
    }
}
