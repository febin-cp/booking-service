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
public class EmployMeeting {
    @Id
    @Column(nullable = false, unique = true)
    private Long id;

    @ManyToOne
    private Meeting meeting;

    @NaturalId
    @Column(nullable = false, unique = true)
    private String meetingOwner;


    @Column(nullable = false)
    private BigDecimal duration;

    @OneToMany(targetEntity = AvailableEmployees.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "mg_fk", referencedColumnName = "id")
    private List<AvailableEmployees> availableEmployees;

    public EmployMeeting(long id, String meetingOwner, BigDecimal duration) {
        this.id = id;
        this.meetingOwner = meetingOwner;
        this.availableEmployees = new ArrayList<>();
        this.duration = duration;
    }

    public void addEmployee(List<AvailableEmployees> slots) {
        for(AvailableEmployees slot : slots){
            availableEmployees.add(slot);
        }
    }

    public EmployMeeting() {
    }

    public void setMeeting(Meeting meeting) {
        this.meeting = meeting;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployMeeting employMeeting = (EmployMeeting) o;
        return Objects.equals(meetingOwner, employMeeting.meetingOwner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(meetingOwner);
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "employees='" + meetingOwner + '\'' +
                '}';
    }
}
