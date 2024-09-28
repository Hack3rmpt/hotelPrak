package com.hotel.hotelPrak.controllers;

import com.hotel.hotelPrak.model.FeedbackModel;
import com.hotel.hotelPrak.service.FeedbackService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/feedback")
public class FeedbackController {
    @Autowired
    public FeedbackService feedbackService;

    @GetMapping("/all")
    public String getAllFeedbacks(Model model) {
        model.addAttribute("feedbacks", feedbackService.findAllFeedback());
        model.addAttribute("feedback", new FeedbackModel());
        return "feedbackList";
    }

    @PostMapping("/add")
    public String addFeedback(@Valid @ModelAttribute("feedback") FeedbackModel feedback, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("feedbacks", feedbackService.findAllFeedback());
            return "feedbackList";
        }
        feedbackService.addFeedback(feedback);
        return "redirect:/feedback/all";
    }

    @PostMapping("/update")
    public String updateFeedback(@Valid @ModelAttribute("feedback") FeedbackModel feedback, BindingResult result) {
        if (result.hasErrors()) {
            return "feedbackList";
        }
        feedbackService.updateFeedback(feedback);
        return "redirect:/feedback/all";
    }

    @PostMapping("/delete")
    public String deleteFeedback(@RequestParam long id) {
        feedbackService.deleteFeedback(id);
        return "redirect:/feedback/all";
    }

    @GetMapping("/all/{id}")
    public String getIdFeedback(@PathVariable("id") long id, Model model) {
        model.addAttribute("feedbacks", feedbackService.findFeedbackById(id));
        model.addAttribute("feedback", new FeedbackModel());
        return "feedbackList";
    }

    @GetMapping("/search")
    public String searchFeedbackByEvaluation(@RequestParam int evaluation, Model model) {
        model.addAttribute("feedbacks", feedbackService.findFeedbackByEvaluation(evaluation));
        model.addAttribute("feedback", new FeedbackModel());
        return "feedbackList";
    }
}