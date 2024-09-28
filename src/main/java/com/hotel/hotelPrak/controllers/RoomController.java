package com.hotel.hotelPrak.controllers;

import com.hotel.hotelPrak.model.RoomModel;
import com.hotel.hotelPrak.service.RoomService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/room")
public class RoomController {
    @Autowired
    public RoomService roomService;

    @GetMapping("/all")
    public String getAllRooms(Model model) {
        model.addAttribute("rooms", roomService.findAllRooms());
        model.addAttribute("room", new RoomModel());
        return "roomList";
    }

    @PostMapping("/add")
    public String addRoom(@Valid @ModelAttribute("room") RoomModel room, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("rooms", roomService.findAllRooms());
            return "roomList";
        }
        roomService.addRoom(room);
        return "redirect:/room/all";
    }

    @PostMapping("/update")
    public String updateRoom(@Valid @ModelAttribute("room") RoomModel room, BindingResult result) {
        if (result.hasErrors()) {
            return "roomList";
        }
        roomService.updateRoom(room);
        return "redirect:/room/all";
    }

    @PostMapping("/delete")
    public String deleteRoom(@RequestParam long id) {
        roomService.deleteRoom(id);
        return "redirect:/room/all";
    }

    @GetMapping("/all/{id}")
    public String getIdRoom(@PathVariable("id") long id, Model model) {
        model.addAttribute("rooms", roomService.findRoomById(id));
        model.addAttribute("room", new RoomModel());
        return "roomList";
    }
}