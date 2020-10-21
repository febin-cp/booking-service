package com.sportsbooking.intdemo.Modal;

import org.hibernate.annotations.NaturalId;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

@Entity
public class Room {
    @Id
    @Column(nullable = false, unique = true)
    private Long id;

    @ManyToOne
    private Hotel hotel;

    @NaturalId
    @Column(nullable = false, unique = true)
    private String roomNumber;

    @Column(nullable = false)
    private int beds;

    @Column(nullable = false)
    private BigDecimal costPerNight;

//    @OneToOne(cascade = CascadeType.ALL)
//    private Reservation reservation;

    @OneToMany(targetEntity = AvailableSlots.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "mg_fk", referencedColumnName = "Id")
    private List<AvailableSlots> availableSlots;

    public Room(long id,String roomNumber, int beds, BigDecimal costPerNight) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.beds = beds;
        this.availableSlots = new ArrayList<>();
        this.costPerNight = costPerNight;
    }

    public void addSlot(List<AvailableSlots> slots) {
        for(AvailableSlots slot : slots){
            availableSlots.add(slot);
        }
    }

    public Room() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public List<AvailableSlots> getAvailableSlots(){
        return availableSlots;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

//    public RoomType getRoomType() {
//        return roomType;
//    }
//
//    public void setRoomType(RoomType roomType) {
//        this.roomType = roomType;
//    }

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public BigDecimal getCostPerNight() {
        return costPerNight;
    }

    public void setCostPerNight(BigDecimal costPerNight) {
        this.costPerNight = costPerNight;
    }

//    public Reservation getReservation() {
//        return reservation;
//    }
//
//    public void setReservation(Reservation reservation) {
//        if (reservation != null) {
//            this.reservation = reservation;
//            reservation.setRoom(this);
//        }
//    }
//
//    public boolean isReserved() {
//        return reservation != null;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(roomNumber, room.roomNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNumber);
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber='" + roomNumber + '\'' +
                '}';
    }
}
