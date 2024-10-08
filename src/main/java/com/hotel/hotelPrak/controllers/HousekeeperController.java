package com.hotel.hotelPrak.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/housekeeper")
@PreAuthorize("hasAnyAuthority('HOUSEKEEPER')")
public class HousekeeperController {

    @GetMapping("/dashboard")
    public String housekeeperDashboard() {
        return "housekeeperDashboard";
    }
}