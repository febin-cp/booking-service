package com.sportsbooking.intdemo.Controllers;

import com.sportsbooking.intdemo.Services.Operations.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("apis/action")
public class ActionController {

    @Autowired
    BookingService booking;

    @PostMapping("/reject")
    public String bookSlotById(@RequestParam Integer id) {
        try {
            if (booking.findAndAcceptMeeting(id)) {
                return ("Meeting Request Accepted Successfully");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Something went wrong! Please try again later...";
    }
}
