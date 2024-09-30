package com.hotel.hotelPrak.controllers;

import com.hotel.hotelPrak.model.FeedbackModel;
import com.hotel.hotelPrak.service.FeedbackService;
import com.hotel.hotelPrak.service.GuestService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/feedback")
public class FeedbackController {
    @Autowired
    public FeedbackService feedbackService;

    @Autowired
    public GuestService guestService;

    @GetMapping("/all")
    public String getAllFeedbacks(Model model) {
        model.addAttribute("feedbacks", feedbackService.findAllFeedback());
        model.addAttribute("feedback", new FeedbackModel());
        model.addAttribute("guests", guestService.findAllGuests());
        return "feedbackList";
    }

    @PostMapping("/add")
    public String addFeedback(@Valid @ModelAttribute("feedback") FeedbackModel feedback, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("feedbacks", feedbackService.findAllFeedback());
            model.addAttribute("guests", guestService.findAllGuests());
            return "feedbackList";
        }
        feedbackService.addFeedback(feedback);
        return "redirect:/feedback/all";
    }

    @PostMapping("/update")
    public String updateFeedback(@Valid @ModelAttribute("feedback") FeedbackModel feedback, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("feedbacks", feedbackService.findAllFeedback());
            model.addAttribute("guests", guestService.findAllGuests());
            return "feedbackList";
        }
        feedbackService.updateFeedback(feedback);
        return "redirect:/feedback/all";
    }

    @PostMapping("/delete")
    public String deleteFeedback(@RequestParam UUID id) {
        feedbackService.deleteFeedback(id);
        return "redirect:/feedback/all";
    }

    @GetMapping("/all/{id}")
    public String getIdFeedback(@PathVariable("id") UUID id, Model model) {
        model.addAttribute("feedback", feedbackService.findFeedbackById(id));
        model.addAttribute("guests", guestService.findAllGuests());
        return "feedbackDetails";
    }
}