package com.hotel.hotelPrak.controllers;

import com.hotel.hotelPrak.model.GuestModel;
import com.hotel.hotelPrak.service.GuestService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/guest")
public class GuestController {
    @Autowired
    public GuestService guestService;

    @GetMapping("/all")
    public String getAllGuests(Model model) {
        model.addAttribute("guests", guestService.findAllGuests());
        model.addAttribute("guest", new GuestModel()); // Добавляем пустой объект GuestModel в модель
        return "guestList";
    }

    @PostMapping("/add")
    public String addGuest(@Valid @ModelAttribute("guest") GuestModel guest, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("guests", guestService.findAllGuests());
            return "guestList";
        }
        guestService.addGuest(guest);
        return "redirect:/guest/all";
    }

    @PostMapping("/update")
    public String updateGuest(@Valid @ModelAttribute("guest") GuestModel guest, BindingResult result) {
        if (result.hasErrors()) {
            return "guestList";
        }
        guestService.updateGuest(guest);
        return "redirect:/guest/all";
    }

    @PostMapping("/delete")
    public String deleteGuest(@RequestParam long id) {
        guestService.deleteGuest(id);
        return "redirect:/guest/all";
    }

    @PostMapping("/soft-delete")
    public String softDeleteGuest(@RequestParam long id) {
        guestService.softDeleteGuest(id);
        return "redirect:/guest/all";
    }

    @GetMapping("/all/{id}")
    public String getIdGuest(@PathVariable("id") long id, Model model) {
        model.addAttribute("guests", guestService.findGuestById(id));
        model.addAttribute("guest", new GuestModel()); // Добавляем пустой объект GuestModel в модель
        return "guestList";
    }

    @GetMapping("/search")
    public String searchGuest(@RequestParam(required = false) String firstName,
                              @RequestParam(required = false) String lastName,
                              Model model) {
        if (firstName != null && !firstName.isEmpty() && lastName != null && !lastName.isEmpty()) {
            model.addAttribute("guests", guestService.findGuestByFirstNameAndLastName(firstName, lastName));
        } else if (firstName != null && !firstName.isEmpty()) {
            model.addAttribute("guests", guestService.findGuestByFirstName(firstName));
        } else if (lastName != null && !lastName.isEmpty()) {
            model.addAttribute("guests", guestService.findGuestByLastName(lastName));
        } else {
            model.addAttribute("guests", guestService.findAllGuests());
        }
        model.addAttribute("guest", new GuestModel()); // Добавляем пустой объект GuestModel в модель
        return "guestList";
    }
}