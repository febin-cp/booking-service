package com.sportsbooking.intdemo.Services.CrudInterfaces;

import com.sportsbooking.intdemo.Modal.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingImpl extends JpaRepository<Booking, Integer> {
}
