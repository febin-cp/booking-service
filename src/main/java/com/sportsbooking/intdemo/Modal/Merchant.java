package com.sportsbooking.intdemo.Modal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
public class Merchant implements Serializable {
    @Id
    @Column(nullable = false, unique = true)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private int stars;

    @Column(nullable = false)
    private String email;

    @OneToMany(mappedBy = "merchant", cascade = CascadeType.ALL)
    // Stop bidirectional relationship which cause a cycle.
    @JsonIgnore
    private Set<Dish> dishes;

    public Merchant() {

    }

    public Merchant(Long id, String name, String location, int stars, String email) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.stars = stars;
        this.email = email;
        this.dishes = new HashSet<>();
    }

    public void addRestaurants(Dish dish) {
        dishes.add(dish);
        dish.setMerchant(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Merchant merchant = (Merchant) o;
        return Objects.equals(location, merchant.location) &&
                Objects.equals(email, merchant.email);
    }


    @Override
    public String toString() {
        return "Merchant{" +
                "id=" + id +
                ", stars=" + stars +
                ", email='" + email + '\'' +
                '}';
    }
}
