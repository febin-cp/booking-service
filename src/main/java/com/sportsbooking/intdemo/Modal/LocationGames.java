package com.sportsbooking.intdemo.Modal;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;

@Data
@Entity
@Table(name = "GameChart")
public class LocationGames {
    @Id
    @GeneratedValue
    private Integer Id;
    private String locationId;
    private ArrayList<GameEvent> gameEvent;
}
