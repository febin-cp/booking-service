package com.sportsbooking.intdemo.Services.CrudInterfaces;

import com.sportsbooking.intdemo.Modal.LocationGames;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationGamesImpl extends JpaRepository<LocationGames, Integer> {
}
