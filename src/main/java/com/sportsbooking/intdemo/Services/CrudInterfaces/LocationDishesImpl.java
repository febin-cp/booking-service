package com.sportsbooking.intdemo.Services.CrudInterfaces;

import com.sportsbooking.intdemo.Modal.Merchant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;


public interface LocationDishesImpl extends JpaRepository<Merchant, Long> {
    Page<Merchant> findDishesByLocation(@Param("location") String location,
                                       Pageable pageable);
}
