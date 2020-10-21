package com.sportsbooking.intdemo.Modal;

import lombok.Data;
import org.hibernate.annotations.NaturalId;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "MerchantList")
public class Merchant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private LocationGames locationGames;

    @NaturalId
    @Column(nullable = false, unique = true)
    private String gameId;

//    @Column(nullable = false)
//    @Enumerated(EnumType.STRING)
//    private RoomType roomType;

//    @Column(nullable = false)
//    private int beds;

    @Column(nullable = false)
    private int costPerNight;

//    @OneToOne(cascade = CascadeType.ALL)
//    private Reservation reservation;
}
