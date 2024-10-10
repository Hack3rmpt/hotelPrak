package com.hotel.hotelPrak.controllers;

import com.hotel.hotelPrak.model.ServiceModel;
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
@RequestMapping("/service")
@PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
public class ServiceModelController {
    @Autowired
    private ServiceModelService serviceModelService;

    @GetMapping("/all")
    public String getAllServices(Model model) {
        model.addAttribute("services", serviceModelService.findAllServices());
        model.addAttribute("service", new ServiceModel());
        return "serviceList";
    }
    @PreAuthorize("hasAnyAuthority('ADMIN')")

    @PostMapping("/add")
    public String addService(@Valid @ModelAttribute("service") ServiceModel service, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("services", serviceModelService.findAllServices());
            return "serviceList";
        }
        serviceModelService.addService(service);
        return "redirect:/service/all";
    }
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping("/update")
    public String updateService(@Valid @ModelAttribute("service") ServiceModel service, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("services", serviceModelService.findAllServices());
            return "serviceList";
        }
        serviceModelService.updateService(service);
        return "redirect:/service/all";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping("/delete")
    public String deleteService(@RequestParam UUID id) {
        serviceModelService.deleteService(id);
        return "redirect:/service/all";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping("/all/{id}")
    public String getIdService(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("service", serviceModelService.findServiceById(id));
        return "serviceDetails";
    }
}
