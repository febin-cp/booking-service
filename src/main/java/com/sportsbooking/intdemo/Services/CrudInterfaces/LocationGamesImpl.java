package com.sportsbooking.intdemo.Services.CrudInterfaces;

import com.sportsbooking.intdemo.Modal.Hotel;
import com.sportsbooking.intdemo.Modal.LocationGames;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LocationGamesImpl extends JpaRepository<Hotel, Integer> {
    Page<Hotel> findGamesByLocation(@Param("location") String location,
                                    Pageable pageable);
}
