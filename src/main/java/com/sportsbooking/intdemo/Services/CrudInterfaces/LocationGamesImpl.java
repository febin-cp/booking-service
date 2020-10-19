package com.sportsbooking.intdemo.Services.CrudInterfaces;

import com.sportsbooking.intdemo.Modal.LocationGames;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationGamesImpl extends JpaRepository<LocationGames, Integer> {
    List<LocationGames> findGamesByMerchantId(String merchId);
}
