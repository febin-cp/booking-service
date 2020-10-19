package com.sportsbooking.intdemo.Modal;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "GameList")
public class LocationGames {
    @Id
    @GeneratedValue
    private Integer Id;
    private String merchantId;
    private String gameEvent;
    @OneToMany(targetEntity = GameEvent.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "mg_fk", referencedColumnName = "Id")
    private List<GameEvent> gameEvents;
}
