package com.sportsbooking.intdemo;

import com.sportsbooking.intdemo.Modal.Hotel;
import com.sportsbooking.intdemo.Modal.Room;
import com.sportsbooking.intdemo.Services.CrudInterfaces.LocationGamesImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalTime;

@Component
@SpringBootTest
public class SampleControllerTest {

    @Autowired
    LocationGamesImpl locationGames;

    public SampleControllerTest(){
        createHotel1();
    }

    @Test
    private void createHotel1() {
        LocalTime earliestCheckInTime = LocalTime.of(9, 0);
        LocalTime latestCheckInTime = LocalTime.of(20, 0);
        LocalTime earliestCheckOutTime = LocalTime.of(12, 0);
        LocalTime latestCheckOutTime = LocalTime.of(14, 0);
        BigDecimal lateCheckoutFee = BigDecimal.valueOf(45.60);

        String location = "bangal";

        Hotel grandHotel = new Hotel("The Grand Hotel", location, 4, "grandhotel.com.au",
                earliestCheckInTime,
                latestCheckInTime,
                earliestCheckOutTime,
                latestCheckOutTime,
                lateCheckoutFee);

        Room room1 = new Room("G1",1, BigDecimal.valueOf(65.12));
        Room room2 = new Room("G2",  2, BigDecimal.valueOf(105.45));
        Room room3 = new Room("G3",  4, BigDecimal.valueOf(205.66));
        Room room4 = new Room("G4",  2, BigDecimal.valueOf(35.40));

        grandHotel.addRoom(room1);
        grandHotel.addRoom(room2);
        grandHotel.addRoom(room3);
        grandHotel.addRoom(room4);

        locationGames.save(grandHotel);
    }
}
