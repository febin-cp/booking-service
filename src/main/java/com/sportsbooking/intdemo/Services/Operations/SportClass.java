package com.sportsbooking.intdemo.Services.Operations;

import com.sportsbooking.intdemo.Modal.AvailableSlots;
import com.sportsbooking.intdemo.Modal.BookingStatus;
import com.sportsbooking.intdemo.Modal.Hotel;
import com.sportsbooking.intdemo.Modal.Room;
import com.sportsbooking.intdemo.Services.CrudInterfaces.LocationGamesImpl;
import com.sportsbooking.intdemo.Services.CrudInterfaces.MerchantOnboarding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class SportClass {

    @Autowired
    LocationGamesImpl locationGames;

    @Autowired
    MerchantOnboarding merchantOnboarding;


    public Room saveMerchant(Room modal){
        return merchantOnboarding.save(modal);
    }

    public Page<Room> getMerchants(Long hotelId, Pageable pageable){
        return merchantOnboarding.findGamesByHotelId(hotelId, pageable );
    }

    public Page<Hotel> getGamesList(String merchId, Pageable pageable){
        Page<Hotel> games = locationGames.findGamesByLocation(merchId, pageable);
        return games;
    }

    public Hotel postGameEvent(Hotel modals){
        return locationGames.save(modals);
    }

    public void loadSampleData(){
        createHotel1();
//        createHotel2();
//        createHotel3();
//        createHotel4();
    }

    private void createHotel1() {
        LocalTime earliestCheckInTime = LocalTime.of(9, 0);
        LocalTime latestCheckInTime = LocalTime.of(20, 0);
        LocalTime earliestCheckOutTime = LocalTime.of(12, 0);
        LocalTime latestCheckOutTime = LocalTime.of(14, 0);
        BigDecimal lateCheckoutFee = BigDecimal.valueOf(45.60);

        String location = "chaitime";

        List<AvailableSlots> slots = new ArrayList<>();

        Hotel grandHotel = new Hotel((long) 1000,"The Grand", location, 2, "grandel.com.au",
                earliestCheckInTime,
                latestCheckInTime,
                earliestCheckOutTime,
                latestCheckOutTime,
                lateCheckoutFee);

        Room room1 = new Room(101,"G1",1, BigDecimal.valueOf(65.12));


        AvailableSlots slot1 = new AvailableSlots(9 ,"1-4", BookingStatus.AVAILABLE);
        AvailableSlots slot2 = new AvailableSlots(10,"5-4", BookingStatus.NOT_AVAILABLE);
        AvailableSlots slot3 = new AvailableSlots(12,"8-4", BookingStatus.AVAILABLE);
        AvailableSlots slot4 = new AvailableSlots(56,"0-4", BookingStatus.AVAILABLE);

        slots.add(slot1);
        slots.add(slot2);
        slots.add(slot3);
        slots.add(slot4);

        room1.addSlot(slots);

        grandHotel.addRoom(room1);

        locationGames.save(grandHotel);
    }

//    private void createHotel2() {
//        LocalTime earliestCheckInTime = LocalTime.of(9, 0);
//        LocalTime latestCheckInTime = LocalTime.of(20, 0);
//        LocalTime earliestCheckOutTime = LocalTime.of(12, 0);
//        LocalTime latestCheckOutTime = LocalTime.of(14, 0);
//        BigDecimal lateCheckoutFee = BigDecimal.valueOf(45.60);
//
//        String location = "coffee";
//
//        List<AvailableSlots> slots = new ArrayList<>();
//        List<AvailableSlots> slots1 = new ArrayList<>();
//        List<AvailableSlots> slots2 = new ArrayList<>();
//
//        Hotel grandHotel = new Hotel("T Hotel", location, 4, "grotel.com.au",
//                earliestCheckInTime,
//                latestCheckInTime,
//                earliestCheckOutTime,
//                latestCheckOutTime,
//                lateCheckoutFee);
//
//        Room room1 = new Room("G1",1, BigDecimal.valueOf(65.12));
//        Room room2 = new Room("G2",  2, BigDecimal.valueOf(105.45));
//        Room room3 = new Room("G3",  4, BigDecimal.valueOf(205.66));
//        Room room4 = new Room("G4",  2, BigDecimal.valueOf(35.40));
//
//        AvailableSlots slot1 = new AvailableSlots("1-4", "available");
//        AvailableSlots slot2 = new AvailableSlots("1-4", "available");
//        AvailableSlots slot3 = new AvailableSlots("1-4", "available");
//        AvailableSlots slot4 = new AvailableSlots("1-4", "available");
//
//        slots.add(slot1);
//        slots.add(slot2);
//        slots.add(slot3);
//
//        slots1.add(slot2);
//        slots1.add(slot3);
//        slots1.add(slot4);
//
//        slots2.add(slot1);
//        slots2.add(slot2);
//        slots2.add(slot3);
//
//        room1.addSlot(slots);
//        room2.addSlot(slots1);
//        room3.addSlot(slots2);
//        room4.addSlot(slots2);
//
//        grandHotel.addRoom(room1);
//        grandHotel.addRoom(room2);
//        grandHotel.addRoom(room3);
//        grandHotel.addRoom(room4);
//
//        locationGames.save(grandHotel);
//    }
//
//    private void createHotel3() {
//        LocalTime earliestCheckInTime = LocalTime.of(9, 0);
//        LocalTime latestCheckInTime = LocalTime.of(20, 0);
//        LocalTime earliestCheckOutTime = LocalTime.of(12, 0);
//        LocalTime latestCheckOutTime = LocalTime.of(14, 0);
//        BigDecimal lateCheckoutFee = BigDecimal.valueOf(45.60);
//
//        String location = "heias";
//
//        Hotel grandHotel = new Hotel("The Gr", location, 40, "grandhel.com.au",
//                earliestCheckInTime,
//                latestCheckInTime,
//                earliestCheckOutTime,
//                latestCheckOutTime,
//                lateCheckoutFee);
//
//        Room room1 = new Room("G1",1, BigDecimal.valueOf(65.12));
//        Room room2 = new Room("G2",  2, BigDecimal.valueOf(105.45));
//        Room room3 = new Room("G3",  4, BigDecimal.valueOf(205.66));
//        Room room4 = new Room("G4",  2, BigDecimal.valueOf(35.40));
//
//        List<AvailableSlots> slots = new ArrayList<>();
//        List<AvailableSlots> slots1 = new ArrayList<>();
//        List<AvailableSlots> slots2 = new ArrayList<>();
//
//        AvailableSlots slot1 = new AvailableSlots("1-4", "available");
//        AvailableSlots slot2 = new AvailableSlots("1-4", "available");
//        AvailableSlots slot3 = new AvailableSlots("1-4", "available");
//        AvailableSlots slot4 = new AvailableSlots("1-4", "available");
//
//        slots.add(slot1);
//        slots.add(slot2);
//        slots.add(slot3);
//        slots.add(slot4);
//
//        slots1.add(slot2);
//        slots1.add(slot3);
//        slots1.add(slot4);
//
//        slots2.add(slot1);
//        slots2.add(slot2);
//        slots2.add(slot3);
//
//        room1.addSlot(slots);
//        room2.addSlot(slots1);
//        room3.addSlot(slots2);
//        room4.addSlot(slots2);
//
//        grandHotel.addRoom(room1);
//        grandHotel.addRoom(room2);
//        grandHotel.addRoom(room3);
//        grandHotel.addRoom(room4);
//
//        locationGames.save(grandHotel);
//    }
//
//    private void createHotel4() {
//        LocalTime earliestCheckInTime = LocalTime.of(9, 0);
//        LocalTime latestCheckInTime = LocalTime.of(20, 0);
//        LocalTime earliestCheckOutTime = LocalTime.of(12, 0);
//        LocalTime latestCheckOutTime = LocalTime.of(14, 0);
//        BigDecimal lateCheckoutFee = BigDecimal.valueOf(45.60);
//
//        String location = "baasdli";
//
//        Hotel grandHotel = new Hotel("The nd Hotel", location, 4, "grandhcom.au",
//                earliestCheckInTime,
//                latestCheckInTime,
//                earliestCheckOutTime,
//                latestCheckOutTime,
//                lateCheckoutFee);
//
//        Room room1 = new Room("G10",1, BigDecimal.valueOf(65.12));
//        Room room2 = new Room("G20",  2, BigDecimal.valueOf(105.45));
//        Room room3 = new Room("G30",  4, BigDecimal.valueOf(205.66));
//        Room room4 = new Room("G40",  2, BigDecimal.valueOf(35.40));
//
//        List<AvailableSlots> slots = new ArrayList<>();
//        List<AvailableSlots> slots1 = new ArrayList<>();
//        List<AvailableSlots> slots2 = new ArrayList<>();
//
//        AvailableSlots slot1 = new AvailableSlots("1-4", "available");
//        AvailableSlots slot2 = new AvailableSlots("1-4", "available");
//        AvailableSlots slot3 = new AvailableSlots("1-4", "available");
//        AvailableSlots slot4 = new AvailableSlots("1-4", "available");
//
//        slots.add(slot1);
//        slots.add(slot2);
//        slots.add(slot3);
//
//        slots1.add(slot2);
//        slots1.add(slot3);
//        slots1.add(slot4);
//
//        slots2.add(slot1);
//        slots2.add(slot2);
//        slots2.add(slot3);
//
//        room1.addSlot(slots);
//        room2.addSlot(slots1);
//        room3.addSlot(slots2);
//        room4.addSlot(slots2);
//
//        grandHotel.addRoom(room1);
//        grandHotel.addRoom(room2);
//        grandHotel.addRoom(room3);
//        grandHotel.addRoom(room4);
//
//        locationGames.save(grandHotel);
//    }

}
