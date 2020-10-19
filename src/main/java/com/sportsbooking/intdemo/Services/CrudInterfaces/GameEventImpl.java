package com.sportsbooking.intdemo.Services.CrudInterfaces;

import com.sportsbooking.intdemo.Modal.GameEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameEventImpl extends JpaRepository<GameEvent, Integer> {
}
