package com.sportsbooking.intdemo.Services.CrudInterfaces;

import com.sportsbooking.intdemo.Modal.AvailableSlots;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingImpl extends JpaRepository<AvailableSlots, Integer> {
}
