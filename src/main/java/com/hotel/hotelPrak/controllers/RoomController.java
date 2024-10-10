package com.hotel.hotelPrak.controllers;

import com.hotel.hotelPrak.model.RoomModel;
import com.hotel.hotelPrak.service.RoomService;
import com.hotel.hotelPrak.service.RoomTypeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/room")
@PreAuthorize("hasAnyAuthority('ADMIN', 'USER', 'HOUSEKEEPER')")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @Autowired
    private RoomTypeService roomTypeService;

    @GetMapping("/all")
    public String getAllRooms(Model model) {
        model.addAttribute("rooms", roomService.findAllRooms());
        model.addAttribute("room", new RoomModel());
        model.addAttribute("roomTypes", roomTypeService.findAllRoomTypes());
        return "roomList";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'HOUSEKEEPER')")

    @PostMapping("/add")
    public String addRoom(@Valid @ModelAttribute("room") RoomModel room, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("rooms", roomService.findAllRooms());
            model.addAttribute("roomTypes", roomTypeService.findAllRoomTypes());
            return "roomList";
        }
        roomService.addRoom(room);
        return "redirect:/room/all";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'HOUSEKEEPER')")
    @PostMapping("/update")
    public String updateRoom(@Valid @ModelAttribute("room") RoomModel room, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("rooms", roomService.findAllRooms());
            model.addAttribute("roomTypes", roomTypeService.findAllRoomTypes());
            return "roomList";
        }
        roomService.updateRoom(room);
        return "redirect:/room/all";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping("/delete")
    public String deleteRoom(@RequestParam UUID id) {
        roomService.deleteRoom(id);
        return "redirect:/room/all";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping("/all/{id}")
    public String getIdRoom(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("room", roomService.findRoomById(id));
        model.addAttribute("roomTypes", roomTypeService.findAllRoomTypes());
        return "roomDetails";
    }
}