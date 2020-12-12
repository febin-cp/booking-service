package com.sportsbooking.intdemo.Controllers;

import com.sportsbooking.intdemo.Modal.Merchant;
import com.sportsbooking.intdemo.Modal.Dish;
import com.sportsbooking.intdemo.Services.Operations.DIshManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/apis/restaurants")
public class RestaurantController {

    @Autowired
    DIshManagementService dao;

    @PostMapping("/onboardMerchant")
    public String onBoardRestaurant(@RequestBody Merchant modals) {
        dao.postRestaurantToSytem(modals);
        return "Updated Successfully";
    }

    @PostMapping("/addDish")
    public String addDishes(@RequestBody Dish modals) {
        dao.saveMerchant(modals);
        return "Added game succesfully";
    }

    @GetMapping("/all")
    public Page<Dish> getAvailableDishWithRestaurant(@RequestParam Long merchId,
                                           Pageable pageable) {
        return dao.getMerchants(merchId, pageable);
    }

    @GetMapping("/updateMerchants")
    public void updateRestaurant() {
        dao.loadSampleData();
    }

    @GetMapping("/location")
    public Page<Merchant> getRestaurantsWithDishName(@RequestParam String location,
                                               Pageable pageable) {
        return dao.getDishesList(location, pageable);
    }
}
