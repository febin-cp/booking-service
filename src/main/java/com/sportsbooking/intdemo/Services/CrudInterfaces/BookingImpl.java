package com.sportsbooking.intdemo.Services.CrudInterfaces;

import com.sportsbooking.intdemo.Modal.AvailableEmployees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingImpl extends JpaRepository<AvailableEmployees, Integer> {
}
