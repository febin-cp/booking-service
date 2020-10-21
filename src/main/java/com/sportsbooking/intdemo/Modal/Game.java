package com.sportsbooking.intdemo.Modal;

import lombok.Data;
import org.hibernate.annotations.NaturalId;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Entity
public class Game {
    @Id
    @Column(nullable = false, unique = true)
    private Long id;

    @ManyToOne
    private Merchant merchant;

    @NaturalId
    @Column(nullable = false, unique = true)
    private String gameEvent;


    @Column(nullable = false)
    private BigDecimal costPerGame;

    @OneToMany(targetEntity = AvailableSlots.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "mg_fk", referencedColumnName = "id")
    private List<AvailableSlots> availableSlots;

    public Game(long id, String gameEvent, BigDecimal costPerNight) {
        this.id = id;
        this.gameEvent = gameEvent;
        this.availableSlots = new ArrayList<>();
        this.costPerGame = costPerNight;
    }

    public void addSlot(List<AvailableSlots> slots) {
        for(AvailableSlots slot : slots){
            availableSlots.add(slot);
        }
    }

    public Game() {
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(gameEvent, game.gameEvent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameEvent);
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber='" + gameEvent + '\'' +
                '}';
    }
}
