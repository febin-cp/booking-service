package com.sportsbooking.intdemo.Controllers;

import com.sportsbooking.intdemo.Modal.Meeting;
import com.sportsbooking.intdemo.Modal.EmployMeeting;
import com.sportsbooking.intdemo.Services.Operations.EventManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/apis/meeting")
public class MeetingController {

    @Autowired
    EventManagementService dao;

    @PostMapping("/addAMeeting")
    public String createMeeting(@RequestBody Meeting modals) {
        dao.postMeetingToSytem(modals);
        return "Updated Successfully";
    }

    @PostMapping("/addEmployees")
    public String addEmployees(@RequestBody EmployMeeting modals) {
        dao.saveMeeting(modals);
        return "Added game succesfully";
    }

    @GetMapping("/all")
    public Page<EmployMeeting> getDetailsMeeting(@RequestParam Long meetId,
                                                              Pageable pageable) {
        return dao.getMeeting(meetId, pageable);
    }

    @GetMapping("/updateMeetings")
    public void updateRestaurant() {
        dao.loadSampleData();
    }

    @GetMapping("/location")
    public Page<Meeting> getRestaurantsWithDishName(@RequestParam String location,
                                                    Pageable pageable) {
        return dao.getEmployeeList(location, pageable);
    }
}
