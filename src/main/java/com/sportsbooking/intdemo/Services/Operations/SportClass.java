package com.sportsbooking.intdemo.Services.Operations;

import com.sportsbooking.intdemo.Modal.AvailableSlots;
import com.sportsbooking.intdemo.Modal.BookingStatus;
import com.sportsbooking.intdemo.Modal.Merchant;
import com.sportsbooking.intdemo.Modal.Game;
import com.sportsbooking.intdemo.Services.CrudInterfaces.LocationGamesImpl;
import com.sportsbooking.intdemo.Services.CrudInterfaces.MerchantOnboarding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class SportClass {

    @Autowired
    LocationGamesImpl locationGames;

    @Autowired
    MerchantOnboarding merchantOnboarding;


    public Game saveMerchant(Game modal){
        return merchantOnboarding.save(modal);
    }

    public Page<Game> getMerchants(Long merchId, Pageable pageable){
        return merchantOnboarding.findGamesByMerchantId(merchId, pageable );
    }

    public Page<Merchant> getGamesList(String merchId, Pageable pageable){
        Page<Merchant> games = locationGames.findGamesByLocation(merchId, pageable);
        return games;
    }

    public Merchant postGameEvent(Merchant modals){
        return locationGames.save(modals);
    }

    public void loadSampleData(){
        createGames1();
        createGames2();
//        createHotel3();
//        createHotel4();
    }

    private void createGames1() {

        String location = "Bangalore";

        List<AvailableSlots> slots = new ArrayList<>();

        Merchant grandMerchant = new Merchant((long) 10050,"The Grand", location, 2, "grandel.com.au");

        Game game1 = new Game(200,"Tennis", BigDecimal.valueOf(65.12));

        AvailableSlots slot1 = new AvailableSlots(1 ,"1-2", BookingStatus.AVAILABLE);
        AvailableSlots slot2 = new AvailableSlots(2,"5-6", BookingStatus.NOT_AVAILABLE);
        AvailableSlots slot3 = new AvailableSlots(3,"6-7", BookingStatus.AVAILABLE);
        AvailableSlots slot4 = new AvailableSlots(4,"7-8", BookingStatus.AVAILABLE);

        slots.add(slot1);
        slots.add(slot2);
        slots.add(slot3);
        slots.add(slot4);

        game1.addSlot(slots);

        grandMerchant.addGame(game1);

        locationGames.save(grandMerchant);
    }

    private void createGames2() {
        String location = "Bangalore";

        List<AvailableSlots> slots = new ArrayList<>();

        Merchant grandMerchant = new Merchant((long) 1004,"Sports Central", location, 2, "grandel.com.au");

        Game game1 = new Game(301,"Badminton", BigDecimal.valueOf(65.12));

        AvailableSlots slot1 = new AvailableSlots(101 ,"1-2", BookingStatus.AVAILABLE);
        AvailableSlots slot2 = new AvailableSlots(102,"5-6", BookingStatus.NOT_AVAILABLE);
        AvailableSlots slot3 = new AvailableSlots(103,"6-7", BookingStatus.AVAILABLE);
        AvailableSlots slot4 = new AvailableSlots(104,"7-8", BookingStatus.AVAILABLE);

        slots.add(slot1);
        slots.add(slot2);
        slots.add(slot3);
        slots.add(slot4);

        game1.addSlot(slots);

        grandMerchant.addGame(game1);

        locationGames.save(grandMerchant);
    }

}
