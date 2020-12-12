package com.sportsbooking.intdemo.Services.CrudInterfaces;

import com.sportsbooking.intdemo.Modal.Dish;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface MerchantOnboarding extends JpaRepository<Dish, Long> {
    Page<Dish> findGamesByMerchantId(@Param("merchantId") Long merchantId,
                                     Pageable pageable);
}
