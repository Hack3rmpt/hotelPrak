package com.hotel.hotelPrak.controllers;

import com.hotel.hotelPrak.model.RoomTypeModel;
import com.hotel.hotelPrak.service.RoomTypeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/roomType")
public class RoomTypeController {
    @Autowired
    private RoomTypeService roomTypeService;

    @GetMapping("/all")
    public String getAllRoomTypes(Model model) {
        model.addAttribute("roomTypes", roomTypeService.findAllRoomTypes());
        model.addAttribute("roomType", new RoomTypeModel());
        return "roomTypeList";
    }

    @PostMapping("/add")
    public String addRoomType(@Valid @ModelAttribute("roomType") RoomTypeModel roomType, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("roomTypes", roomTypeService.findAllRoomTypes());
            return "roomTypeList";
        }
        roomTypeService.addRoomType(roomType);
        return "redirect:/roomType/all";
    }

    @PostMapping("/update")
    public String updateRoomType(@Valid @ModelAttribute("roomType") RoomTypeModel roomType, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("roomTypes", roomTypeService.findAllRoomTypes());
            return "roomTypeList";
        }
        roomTypeService.updateRoomType(roomType);
        return "redirect:/roomType/all";
    }

    @PostMapping("/delete")
    public String deleteRoomType(@RequestParam UUID id) {
        roomTypeService.deleteRoomType(id);
        return "redirect:/roomType/all";
    }

    @GetMapping("/all/{id}")
    public String getIdRoomType(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("roomType", roomTypeService.findRoomTypeById(id));
        return "roomTypeDetails";
    }
}