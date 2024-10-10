package com.hotel.hotelPrak.controllers;

import com.hotel.hotelPrak.model.GuestServiceModel;
import com.hotel.hotelPrak.service.GuestServiceModelService;
import com.hotel.hotelPrak.service.GuestService;
import com.hotel.hotelPrak.service.ServiceModelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/guestService")
@PreAuthorize("hasAnyAuthority('ADMIN', 'USER', 'HOUSEKEEPER')")
public class GuestServiceModelController {
    @Autowired
    private GuestServiceModelService guestServiceModelService;

    @Autowired
    private GuestService guestService;

    @Autowired
    private ServiceModelService serviceModelService;

    @GetMapping("/all")
    public String getAllGuestServices(Model model) {
        model.addAttribute("guestServices", guestServiceModelService.findAllGuestServices());
        model.addAttribute("guestService", new GuestServiceModel()); // Добавляем новый объект GuestServiceModel
        model.addAttribute("guests", guestService.findAllGuests());
        model.addAttribute("services", serviceModelService.findAllServices());
        return "guestServiceList";
    }

    @PostMapping("/add")
    public String addGuestService(@Valid @ModelAttribute("guestService") GuestServiceModel guestServiceModel, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("guestServices", guestServiceModelService.findAllGuestServices());
            model.addAttribute("guests", guestService.findAllGuests());
            model.addAttribute("services", serviceModelService.findAllServices());
            return "guestServiceList";
        }
        guestServiceModelService.addGuestService(guestServiceModel);
        return "redirect:/guestService/all";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'HOUSEKEEPER')")
    @PostMapping("/update")
    public String updateGuestService(@Valid @ModelAttribute("guestService") GuestServiceModel guestServiceModel, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("guestServices", guestServiceModelService.findAllGuestServices());
            model.addAttribute("guests", guestService.findAllGuests());
            model.addAttribute("services", serviceModelService.findAllServices());
            return "guestServiceList";
        }
        guestServiceModelService.updateGuestService(guestServiceModel);
        return "redirect:/guestService/all";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'HOUSEKEEPER')")
    @PostMapping("/delete")
    public String deleteGuestService(@RequestParam UUID id) {
        guestServiceModelService.deleteGuestService(id);
        return "redirect:/guestService/all";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping("/all/{id}")
    public String getIdGuestService(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("guestService", guestServiceModelService.findGuestServiceById(id));
        model.addAttribute("guests", guestService.findAllGuests());
        model.addAttribute("services", serviceModelService.findAllServices());
        return "guestServiceDetails";
    }
}