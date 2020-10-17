package com.sportsbooking.intdemo.Services;

import com.sportsbooking.intdemo.Modal.Booking;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrgsSports extends JpaRepository<Booking, Integer> {
}
