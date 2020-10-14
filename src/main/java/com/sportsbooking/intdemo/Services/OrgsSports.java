package com.sportsbooking.intdemo.Services;

import com.sportsbooking.intdemo.Modal.Modal;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrgsSports extends JpaRepository<Modal, Integer> {
}
