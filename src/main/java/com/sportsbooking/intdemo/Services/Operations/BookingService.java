package com.sportsbooking.intdemo.Services.Operations;

import com.sportsbooking.intdemo.Modal.AvailableDishes;
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

    public boolean findAndBookDish(int id) {
        Optional<AvailableDishes> dish = booking.findById(id);
        System.out.println("Slot fetched" + dish);
        if (dish.isPresent()) {
            AvailableDishes updateDishQuantiry = dish.get();
            if (updateDishQuantiry.getStatus().equals(BookingStatus.AVAILABLE)) {
                updateDishQuantiry.setStatus(BookingStatus.NOT_AVAILABLE);
                booking.save(updateDishQuantiry);
                return true;
            }  else{
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "No more of that dish available");
            }
        } else {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "No such dish in this restaurant");
        }
    }
}
