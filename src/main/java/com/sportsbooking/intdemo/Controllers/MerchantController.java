package com.sportsbooking.intdemo.Controllers;

import com.sportsbooking.intdemo.Modal.LocationGames;
import com.sportsbooking.intdemo.Modal.Merchant;
import com.sportsbooking.intdemo.Services.Operations.SportClass;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String hello(@RequestBody LocationGames modals) {
        dao.saveGamePerLocation(modals);
        return "Done";
    }

    @PostMapping("/ticket123")
    public String hello123(@RequestBody Merchant modals) {
        dao.saveMerchant(modals);
        return "Done";
    }

    @GetMapping("/ticket123")
    public List<Merchant> hello1() {
        return dao.getMerchants();
    }

    @GetMapping("/ticket123123")
    public List<Merchant> hello111(@RequestParam String merchId) {
        return dao.getMerchants(merchId);
    }

}
