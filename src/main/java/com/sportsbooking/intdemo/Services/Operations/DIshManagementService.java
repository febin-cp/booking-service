package com.sportsbooking.intdemo.Services.Operations;

import com.sportsbooking.intdemo.Modal.AvailableDishes;
import com.sportsbooking.intdemo.Modal.BookingStatus;
import com.sportsbooking.intdemo.Modal.Merchant;
import com.sportsbooking.intdemo.Modal.Dish;
import com.sportsbooking.intdemo.Services.CrudInterfaces.LocationDishesImpl;
import com.sportsbooking.intdemo.Services.CrudInterfaces.MerchantOnboarding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class DIshManagementService {

    @Autowired
    LocationDishesImpl locationDishes;

    @Autowired
    MerchantOnboarding merchantOnboarding;


    public Dish saveMerchant(Dish modal){
        return merchantOnboarding.save(modal);
    }

    public Page<Dish> getMerchants(Long merchId, Pageable pageable){
        return merchantOnboarding.findGamesByMerchantId(merchId, pageable );
    }

    public Page<Merchant> getDishesList(String merchId, Pageable pageable){
        Page<Merchant> games = locationDishes.findDishesByLocation(merchId, pageable);
        return games;
    }

    public Merchant postRestaurantToSytem(Merchant modals){
        return locationDishes.save(modals);
    }

    public void loadSampleData(){
        createRestaurants1();
        createRestaurants2();
    }

    private void createRestaurants1() {

        String location = "Bangalore";

        List<AvailableDishes> dishes = new ArrayList<>();

        Merchant grandMerchant = new Merchant((long) 10050,"The Grand", location, 2, "grandel.com");

        Dish dish1 = new Dish(200,"Chicken Biriyani", BigDecimal.valueOf(65.12));

        AvailableDishes dish1Quants1 = new AvailableDishes(1 ,"1-2", BookingStatus.AVAILABLE);

        dishes.add(dish1Quants1);

        dish1.addDish(dishes);

        grandMerchant.addRestaurants(dish1);

        locationDishes.save(grandMerchant);
    }

    private void createRestaurants2() {

        String location = "Bangalore";

        List<AvailableDishes> dishes = new ArrayList<>();

        Merchant grandMerchant = new Merchant((long) 10051,"The Empire", location, 3, "theempite.com");

        Dish dish1 = new Dish(201,"Veg Stew", BigDecimal.valueOf(65.12));

        AvailableDishes dish1Quants1 = new AvailableDishes(1 ,"1-2", BookingStatus.AVAILABLE);

        dishes.add(dish1Quants1);

        dish1.addDish(dishes);

        grandMerchant.addRestaurants(dish1);

        locationDishes.save(grandMerchant);
    }

}
