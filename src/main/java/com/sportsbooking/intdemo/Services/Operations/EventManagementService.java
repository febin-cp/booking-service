package com.sportsbooking.intdemo.Services.Operations;

import com.sportsbooking.intdemo.Modal.AvailableEmployees;
import com.sportsbooking.intdemo.Modal.BookingStatus;
import com.sportsbooking.intdemo.Modal.Meeting;
import com.sportsbooking.intdemo.Modal.EmployMeeting;
import com.sportsbooking.intdemo.Services.CrudInterfaces.MeetingEmployeeImpl;
import com.sportsbooking.intdemo.Services.CrudInterfaces.CreateMeetingImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class EventManagementService {

    @Autowired
    MeetingEmployeeImpl meetingEmployee;

    @Autowired
    CreateMeetingImpl createMeetingImpl;


    public EmployMeeting saveMeeting(EmployMeeting modal){
        return createMeetingImpl.save(modal);
    }

    public Page<EmployMeeting> getMeeting(Long merchId, Pageable pageable){
        return createMeetingImpl.findMeetingByMeetingId(merchId, pageable );
    }

    public Page<Meeting> getEmployeeList(String merchId, Pageable pageable){
        Page<Meeting> games = meetingEmployee.findMeetingByLocation(merchId, pageable);
        return games;
    }

    public Meeting postMeetingToSytem(Meeting modals){
        return meetingEmployee.save(modals);
    }

    public void loadSampleData(){
        createMeeting1();
        createMeeting2();
    }

    private void createMeeting1() {

        String location = "Madrid";

        List<AvailableEmployees> dishes = new ArrayList<>();

        Meeting grandMeeting = new Meeting((long) 10053,"The Otto", location, "grandel.com");

        EmployMeeting employMeeting1 = new EmployMeeting(203,"Veena", BigDecimal.valueOf(2));

        AvailableEmployees dish1Quants1 = new AvailableEmployees(5 ,"1-2", BookingStatus.AVAILABLE);
        AvailableEmployees dish1Quants2 = new AvailableEmployees(6 ,"1-2", BookingStatus.AVAILABLE);
        AvailableEmployees dish1Quants3 = new AvailableEmployees(8 ,"1-2", BookingStatus.AVAILABLE);


        dishes.add(dish1Quants1);
        dishes.add(dish1Quants2);
        dishes.add(dish1Quants3);

        employMeeting1.addEmployee(dishes);

        grandMeeting.addMeetings(employMeeting1);

        meetingEmployee.save(grandMeeting);
    }

    private void createMeeting2() {

        String location = "Bercelona";

        List<AvailableEmployees> employees = new ArrayList<>();

        Meeting grandMeeting = new Meeting((long) 10051,"The Empire", location, "theempite.com");

        EmployMeeting employMeeting1 = new EmployMeeting(201,"Veg Stew", BigDecimal.valueOf(65.12));

        AvailableEmployees dish1Quants1 = new AvailableEmployees(1 ,"1-2", BookingStatus.AVAILABLE);

        employees.add(dish1Quants1);

        employMeeting1.addEmployee(employees);

        grandMeeting.addMeetings(employMeeting1);

        meetingEmployee.save(grandMeeting);
    }

}
