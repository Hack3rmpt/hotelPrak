package com.hotel.hotelPrak.controllers;

import com.hotel.hotelPrak.model.BedTypeModel;
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
@RequestMapping("/bedType")
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class BedTypeController {
    @Autowired
    private BedTypeService bedTypeService;

    @GetMapping("/all")
    public String getAllBedTypes(Model model) {
        model.addAttribute("bedTypes", bedTypeService.findAllBedTypes());
        model.addAttribute("bedType", new BedTypeModel());
        return "bedTypeList";
    }

    @PostMapping("/add")
    public String addBedType(@Valid @ModelAttribute("bedType") BedTypeModel bedType, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("bedTypes", bedTypeService.findAllBedTypes());
            return "bedTypeList";
        }
        bedTypeService.addBedType(bedType);
        return "redirect:/bedType/all";
    }

    @PostMapping("/update")
    public String updateBedType(@Valid @ModelAttribute("bedType") BedTypeModel bedType, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("bedTypes", bedTypeService.findAllBedTypes());
            return "bedTypeList";
        }
        bedTypeService.updateBedType(bedType);
        return "redirect:/bedType/all";
    }

    @PostMapping("/delete")
    public String deleteBedType(@RequestParam UUID id) {
        bedTypeService.deleteBedType(id);
        return "redirect:/bedType/all";
    }

    @GetMapping("/all/{id}")
    public String getIdBedType(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("bedType", bedTypeService.findBedTypeById(id));
        return "bedTypeDetails";
    }
}