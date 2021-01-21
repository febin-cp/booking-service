package com.sportsbooking.intdemo.Services.CrudInterfaces;

import com.sportsbooking.intdemo.Modal.EmployMeeting;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface CreateMeetingImpl extends JpaRepository<EmployMeeting, Long> {
    Page<EmployMeeting> findMeetingByMeetingId(@Param("meetingId") Long meetingId,
                                              Pageable pageable);
}
