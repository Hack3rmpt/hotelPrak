package com.hotel.hotelPrak.controllers;

import com.hotel.hotelPrak.model.RoomBedModel;
import com.hotel.hotelPrak.service.RoomBedService;
import com.hotel.hotelPrak.service.RoomService;
import com.hotel.hotelPrak.service.BedTypeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/roomBed")
@PreAuthorize("hasAnyAuthority('ADMIN', 'HOUSEKEEPER')")
public class RoomBedController {
    @Autowired
    private RoomBedService roomBedService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private BedTypeService bedTypeService;

    @GetMapping("/all")
    public String getAllRoomBeds(Model model) {
        model.addAttribute("roomBeds", roomBedService.findAllRoomBeds());
        model.addAttribute("roomBed", new RoomBedModel());
        model.addAttribute("rooms", roomService.findAllRooms());
        model.addAttribute("bedTypes", bedTypeService.findAllBedTypes());
        return "roomBedList";
    }

    @PostMapping("/add")
    public String addRoomBed(@Valid @ModelAttribute("roomBed") RoomBedModel roomBed, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("roomBeds", roomBedService.findAllRoomBeds());
            model.addAttribute("rooms", roomService.findAllRooms());
            model.addAttribute("bedTypes", bedTypeService.findAllBedTypes());
            return "roomBedList";
        }
        roomBedService.addRoomBed(roomBed);
        return "redirect:/roomBed/all";
    }

    @PostMapping("/update")
    public String updateRoomBed(@Valid @ModelAttribute("roomBed") RoomBedModel roomBed, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("roomBeds", roomBedService.findAllRoomBeds());
            model.addAttribute("rooms", roomService.findAllRooms());
            model.addAttribute("bedTypes", bedTypeService.findAllBedTypes());
            return "roomBedList";
        }
        roomBedService.updateRoomBed(roomBed);
        return "redirect:/roomBed/all";
    }

    @PostMapping("/delete")
    public String deleteRoomBed(@RequestParam UUID id) {
        roomBedService.deleteRoomBed(id);
        return "redirect:/roomBed/all";
    }

    @GetMapping("/all/{id}")
    public String getIdRoomBed(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("roomBed", roomBedService.findRoomBedById(id));
        model.addAttribute("rooms", roomService.findAllRooms());
        model.addAttribute("bedTypes", bedTypeService.findAllBedTypes());
        return "roomBedDetails";
    }
}