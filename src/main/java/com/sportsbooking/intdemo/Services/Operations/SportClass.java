package com.sportsbooking.intdemo.Services.Operations;

import com.sportsbooking.intdemo.Modal.Hotel;
import com.sportsbooking.intdemo.Modal.LocationGames;
import com.sportsbooking.intdemo.Modal.Merchant;
import com.sportsbooking.intdemo.Modal.Room;
import com.sportsbooking.intdemo.Services.CrudInterfaces.GameEventImpl;
import com.sportsbooking.intdemo.Services.CrudInterfaces.LocationGamesImpl;
import com.sportsbooking.intdemo.Services.CrudInterfaces.MerchantOnboarding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;

@Service
public class SportClass {

    @Autowired
    LocationGamesImpl locationGames;

    @Autowired
    MerchantOnboarding merchantOnboarding;

    @Autowired
    GameEventImpl gameEvent;

    public Hotel saveGamePerLocation(Hotel modal){
        return locationGames.save(modal);
    }

    public Room saveMerchant(Room modal){
        return merchantOnboarding.save(modal);
    }
//    public List<Merchant> getMerchants(String merchId){
//        return merchantOnboarding.findByMerchantId(merchId);
//    }
    public Page<Room> getMerchants(Long hotelId, Pageable pageable){
        return merchantOnboarding.findGamesByHotelId(hotelId, pageable );
    }
    public Page<Hotel> getGamesList(String merchId, Pageable pageable){
        Page<Hotel> games = locationGames.findGamesByLocation(merchId, pageable);
        return games;
    }
    public Hotel postGameEvent(Hotel modals){
        createHotel1();
        createHotel2();
        createHotel3();
        createHotel4();
        return locationGames.save(modals);
    }

    private void createHotel1() {
        LocalTime earliestCheckInTime = LocalTime.of(9, 0);
        LocalTime latestCheckInTime = LocalTime.of(20, 0);
        LocalTime earliestCheckOutTime = LocalTime.of(12, 0);
        LocalTime latestCheckOutTime = LocalTime.of(14, 0);
        BigDecimal lateCheckoutFee = BigDecimal.valueOf(45.60);

        String location = "bangal";

        Hotel grandHotel = new Hotel("The Grand", location, 2, "grandel.com.au",
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

    private void createHotel2() {
        LocalTime earliestCheckInTime = LocalTime.of(9, 0);
        LocalTime latestCheckInTime = LocalTime.of(20, 0);
        LocalTime earliestCheckOutTime = LocalTime.of(12, 0);
        LocalTime latestCheckOutTime = LocalTime.of(14, 0);
        BigDecimal lateCheckoutFee = BigDecimal.valueOf(45.60);

        String location = "bangal";

        Hotel grandHotel = new Hotel("T Hotel", location, 4, "grotel.com.au",
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

    private void createHotel3() {
        LocalTime earliestCheckInTime = LocalTime.of(9, 0);
        LocalTime latestCheckInTime = LocalTime.of(20, 0);
        LocalTime earliestCheckOutTime = LocalTime.of(12, 0);
        LocalTime latestCheckOutTime = LocalTime.of(14, 0);
        BigDecimal lateCheckoutFee = BigDecimal.valueOf(45.60);

        String location = "bangal";

        Hotel grandHotel = new Hotel("The Gr", location, 40, "grandhel.com.au",
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

    private void createHotel4() {
        LocalTime earliestCheckInTime = LocalTime.of(9, 0);
        LocalTime latestCheckInTime = LocalTime.of(20, 0);
        LocalTime earliestCheckOutTime = LocalTime.of(12, 0);
        LocalTime latestCheckOutTime = LocalTime.of(14, 0);
        BigDecimal lateCheckoutFee = BigDecimal.valueOf(45.60);

        String location = "bangal";

        Hotel grandHotel = new Hotel("The nd Hotel", location, 4, "grandhcom.au",
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
