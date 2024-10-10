package com.hotel.hotelPrak.controllers;

import com.hotel.hotelPrak.model.BookingModel;
import com.hotel.hotelPrak.service.BookingService;
import com.hotel.hotelPrak.service.GuestService;
import com.hotel.hotelPrak.service.RoomService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/booking")
@PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @Autowired
    private GuestService guestService;

    @Autowired
    private RoomService roomService;

    @GetMapping("/all")
    public String getAllBookings(Model model) {
        model.addAttribute("bookings", bookingService.findAllBookings());
        model.addAttribute("booking", new BookingModel());
        model.addAttribute("guests", guestService.findAllGuests());
        model.addAttribute("rooms", roomService.findAllRooms());
        return "bookingList";
    }

    @PostMapping("/add")
    public String addBooking(@Valid @ModelAttribute("booking") BookingModel booking, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("bookings", bookingService.findAllBookings());
            model.addAttribute("guests", guestService.findAllGuests());
            model.addAttribute("rooms", roomService.findAllRooms());
            return "bookingList";
        }
        bookingService.addBooking(booking);
        return "redirect:/booking/all";
    }
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping("/update")
    public String updateBooking(@Valid @ModelAttribute("booking") BookingModel booking, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("bookings", bookingService.findAllBookings());
            model.addAttribute("guests", guestService.findAllGuests());
            model.addAttribute("rooms", roomService.findAllRooms());
            return "bookingList";
        }
        bookingService.updateBooking(booking);
        return "redirect:/booking/all";
    }
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping("/delete")
    public String deleteBooking(@RequestParam UUID id) {
        bookingService.deleteBooking(id);
        return "redirect:/booking/all";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping("/all/{id}")
    public String getIdBooking(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("booking", bookingService.findBookingById(id));
        model.addAttribute("guests", guestService.findAllGuests());
        model.addAttribute("rooms", roomService.findAllRooms());
        return "bookingDetails";
    }
}