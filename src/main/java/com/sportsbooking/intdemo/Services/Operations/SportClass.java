package com.sportsbooking.intdemo.Services.Operations;

import com.sportsbooking.intdemo.Modal.LocationGames;
import com.sportsbooking.intdemo.Modal.Merchant;
import com.sportsbooking.intdemo.Services.CrudInterfaces.LocationGamesImpl;
import com.sportsbooking.intdemo.Services.CrudInterfaces.MerchantOnboarding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SportClass {

    @Autowired
    LocationGamesImpl locationGames;

    @Autowired
    MerchantOnboarding merchantOnboarding;

    public LocationGames saveGamePerLocation(LocationGames modal){
        return locationGames.save(modal);
    }

    public Merchant saveMerchant(Merchant modal){
        return merchantOnboarding.save(modal);
    }
    public List<Merchant> getMerchants(String merchId){
        return merchantOnboarding.findByMerchantId(merchId);
    }
    public List<Merchant> getMerchants(){
        return merchantOnboarding.findAll();
    }
    public List<LocationGames> getGamesList(String merchId){
        return locationGames.findGamesByMerchantId(merchId);
    }
}
