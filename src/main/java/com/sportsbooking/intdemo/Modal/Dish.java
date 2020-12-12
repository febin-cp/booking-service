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
public class Dish {
    @Id
    @Column(nullable = false, unique = true)
    private Long id;

    @ManyToOne
    private Merchant merchant;

    @NaturalId
    @Column(nullable = false, unique = true)
    private String dishName;


    @Column(nullable = false)
    private BigDecimal costPerDish;

    @OneToMany(targetEntity = AvailableDishes.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "mg_fk", referencedColumnName = "id")
    private List<AvailableDishes> availableDishes;

    public Dish(long id, String dishName, BigDecimal costPerDish) {
        this.id = id;
        this.dishName = dishName;
        this.availableDishes = new ArrayList<>();
        this.costPerDish = costPerDish;
    }

    public void addDish(List<AvailableDishes> slots) {
        for(AvailableDishes slot : slots){
            availableDishes.add(slot);
        }
    }

    public Dish() {
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        return Objects.equals(dishName, dish.dishName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dishName);
    }

    @Override
    public String toString() {
        return "Restaurat{" +
                "dish='" + dishName + '\'' +
                '}';
    }
}
