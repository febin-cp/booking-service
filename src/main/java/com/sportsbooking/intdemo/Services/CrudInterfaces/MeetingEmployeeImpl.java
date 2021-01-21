package com.sportsbooking.intdemo.Services.CrudInterfaces;

import com.sportsbooking.intdemo.Modal.Meeting;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;


public interface MeetingEmployeeImpl extends JpaRepository<Meeting, Long> {
    Page<Meeting> findMeetingByLocation(@Param("location") String location,
                                       Pageable pageable);
}
