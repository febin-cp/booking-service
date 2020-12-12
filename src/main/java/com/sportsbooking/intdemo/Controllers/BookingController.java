package com.sportsbooking.intdemo.Controllers;

import com.sportsbooking.intdemo.Services.Operations.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("apis/transaction")
public class BookingController {

    @Autowired
    BookingService booking;

    @PostMapping("/booking")
    public String bookSlotById(@RequestParam Integer id) {
        try {
            if (booking.findAndBookDish(id)) {
                return ("Order Placed Successfully");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Order Placing Failed!! Please try again later";
    }
}
