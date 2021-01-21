package com.sportsbooking.intdemo.Services.Operations;

import com.sportsbooking.intdemo.Modal.AvailableEmployees;
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

    public boolean findAndAcceptMeeting(int id) {
        Optional<AvailableEmployees> meeting = booking.findById(id);
        System.out.println("Slot fetched" + meeting);
        if (meeting.isPresent()) {
            AvailableEmployees updateMeetingRequest = meeting.get();
            if (updateMeetingRequest.getStatus().equals(BookingStatus.AVAILABLE)) {
                updateMeetingRequest.setStatus(BookingStatus.NOT_AVAILABLE);
                booking.save(updateMeetingRequest);
                return true;
            }  else{
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Couldn't respond invite");
            }
        } else {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Not accepting or no meeting with the ID found!");
        }
    }
}
