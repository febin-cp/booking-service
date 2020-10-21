package com.sportsbooking.intdemo.Controllers;

import com.sportsbooking.intdemo.Modal.Merchant;
import com.sportsbooking.intdemo.Modal.Game;
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


@RestController
@RequestMapping("/apis/games")
public class GamesSearchController {

    @Autowired
    SportClass dao;

    @PostMapping("/onboardMerchant")
    public String addMerchants(@RequestBody Merchant modals) {
        dao.postGameEvent(modals);
        return "Updated Successfully";
    }

    @PostMapping("/addGame")
    public String addGames(@RequestBody Game modals) {
        dao.saveMerchant(modals);
        return "Added game succesfully";
    }

    @GetMapping("/all")
    public Page<Game> getGamesWithMerchant(@RequestParam Long merchId,
                                           Pageable pageable) {
        return dao.getMerchants(merchId, pageable);
    }

    @GetMapping("/updateMerchants")
    public void hello111() {
        dao.loadSampleData();
    }

    @GetMapping("/location")
    public Page<Merchant> getGamesWithLocation(@RequestParam String location,
                                               Pageable pageable) {
        return dao.getGamesList(location, pageable);
    }
}
