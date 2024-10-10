package com.hotel.hotelPrak.controllers;

import com.hotel.hotelPrak.model.GuestModel;
import com.hotel.hotelPrak.service.GuestService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/guest")
public class GuestController {
    @Autowired
    private GuestService guestService;

    @GetMapping("/all")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public String getAllGuests(Model model) {
        model.addAttribute("guests", guestService.findAllGuests());
        model.addAttribute("guest", new GuestModel());
        return "guestList";
    }
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    @PostMapping("/add")
    public String addGuest(@Valid @ModelAttribute("guest") GuestModel guest, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("guests", guestService.findAllGuests());
            return "guestList";
        }
        guestService.addGuest(guest);
        return "redirect:/guest/all";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping("/update")
    public String updateGuest(@Valid @ModelAttribute("guest") GuestModel guest, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("guests", guestService.findAllGuests());
            return "guestList";
        }
        guestService.updateGuest(guest);
        return "redirect:/guest/all";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping("/delete")
    public String deleteGuest(@RequestParam UUID id) {
        guestService.deleteGuest(id);
        return "redirect:/guest/all";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping("/all/{id}")
    public String getIdGuest(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("guest", guestService.findGuestById(id));
        return "guestDetails";
    }
}