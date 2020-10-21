package com.sportsbooking.intdemo.Controllers;

import com.sportsbooking.intdemo.Modal.Hotel;
import com.sportsbooking.intdemo.Modal.LocationGames;
import com.sportsbooking.intdemo.Modal.Merchant;
import com.sportsbooking.intdemo.Modal.Room;
import com.sportsbooking.intdemo.Services.Operations.SportClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/uploadData")
public class MerchantController {

    @Autowired
    SportClass dao;

    @PostMapping("/ticket")
    public String hello(@RequestBody Hotel modals) {
        dao.postGameEvent(modals);
        return "Done";
    }

    @PostMapping("/ticket123")
    public String hello123(@RequestBody Room modals) {
        dao.saveMerchant(modals);
        return "Done";
    }

    @GetMapping("/ticket123")
    public Page<Room> hello1(@RequestParam Long merchId,
                             Pageable pageable) {
        return dao.getMerchants(merchId, pageable);
    }

    @GetMapping("/ticket123123")
    public void hello111() {
        dao.loadSampleData();

//        return dao.getMerchants(merchId);
    }

    @GetMapping("/tick")
    public Page<Hotel> hello1111(@RequestParam String merchId,
                                 Pageable pageable) {
        return dao.getGamesList(merchId, pageable);
    }

//    @PostMapping("/tic")
//    public List<LocationGames> hello1(@RequestParam String merchId) {
//        return dao.getGamesList(merchId);
//    }

}
