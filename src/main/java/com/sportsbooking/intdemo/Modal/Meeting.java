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
public class Meeting implements Serializable {
    @Id
    @Column(nullable = false, unique = true)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String email;

    @OneToMany(mappedBy = "meeting", cascade = CascadeType.ALL)
    // Stop bidirectional relationship which cause a cycle.
    @JsonIgnore
    private Set<EmployMeeting> employMeetings;

    public Meeting() {

    }

    public Meeting(Long id, String title, String location, String email) {
        this.id = id;
        this.title = title;
        this.location = location;
        this.email = email;
        this.employMeetings = new HashSet<>();
    }

    public void addMeetings(EmployMeeting employMeeting) {
        employMeetings.add(employMeeting);
        employMeeting.setMeeting(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meeting meeting = (Meeting) o;
        return Objects.equals(location, meeting.location) &&
                Objects.equals(email, meeting.email);
    }


    @Override
    public String toString() {
        return "Meeting{" +
                "id=" + id +
                ", email='" + email + '\'' +
                '}';
    }
}
