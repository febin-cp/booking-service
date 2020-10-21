package com.sportsbooking.intdemo.Services.CrudInterfaces;

import com.sportsbooking.intdemo.Modal.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface MerchantOnboarding extends JpaRepository<Room, Integer> {
    Page<Room> findGamesByHotelId(@Param("hotelId") Long hotelId,
                                    Pageable pageable);
}
