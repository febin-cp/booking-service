package com.sportsbooking.intdemo.Controllers;

import com.sportsbooking.intdemo.Modal.Modal;
import com.sportsbooking.intdemo.Services.OrgsSports;
import com.sportsbooking.intdemo.Services.SportClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/uploadData")
public class SampleController {

    @Autowired
    SportClass dao;

    @PostMapping("/ticket")
    public String hello(@RequestBody Modal modals) {
        dao.saveVal(modals);
        return "Done";
    }
}
