package com.marsvisit.mars_visit_application.controller;

import com.marsvisit.mars_visit_application.model.MarsApplication;
import com.marsvisit.mars_visit_application.repository.MarsApplicationRepository;
import com.marsvisit.mars_visit_application.validation.Stage1;
import com.marsvisit.mars_visit_application.validation.Stage2;
import com.marsvisit.mars_visit_application.validation.Stage3;
import jakarta.validation.groups.Default;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("marsApplication")
public class MarsApplicationController {

    private final MarsApplicationRepository marsApplicationRepository;

    @Autowired
    public MarsApplicationController(MarsApplicationRepository marsApplicationRepository) {
        this.marsApplicationRepository = marsApplicationRepository;
    }

    // Stage 1: Personal Information
    @GetMapping("/apply/personal")
    public String showPersonalInfoForm(Model model) {
        if (!model.containsAttribute("marsApplication")) {
            model.addAttribute("marsApplication", new MarsApplication());
        }
        return "personal_info";
    }

    @PostMapping("/apply/personal")
    public String processPersonalInfo(@Validated(Stage1.class) MarsApplication marsApplication, BindingResult result) {
        if (result.hasErrors()) {
            return "personal_info";
        }
        System.out.println("Stage 1 validated: " + marsApplication);
        return "redirect:/apply/travel";
    }

    // Stage 2: Travel Preferences
    @GetMapping("/apply/travel")
    public String showTravelPreferencesForm(Model model) {
        if (!model.containsAttribute("marsApplication")) {
            return "redirect:/apply/personal";
        }
        return "travel_preferences";
    }

    @PostMapping("/apply/travel")
    public String processTravelPreferences(@Validated(Stage2.class) MarsApplication marsApplication, BindingResult result) {
        if (result.hasErrors()) {
            return "travel_preferences";
        }
        return "redirect:/apply/health";
    }

    // Stage 3: Health and Safety
    @GetMapping("/apply/health")
    public String showHealthSafetyForm(Model model) {
        if (!model.containsAttribute("marsApplication")) {
            return "redirect:/apply/personal";
        }
        return "health_safety";
    }

    @PostMapping("/apply/health")
    public String processHealthSafety(@Validated(Stage3.class) MarsApplication marsApplication, BindingResult result) {
        if (result.hasErrors()) {
            return "health_safety";
        }
        // Persist the completed application
        marsApplicationRepository.save(marsApplication);
        return "redirect:/apply/result";
    }

    // Final Stage: Display the result/summary
    @GetMapping("/apply/result")
    public String showResult(Model model) {
        if (!model.containsAttribute("marsApplication")) {
            return "redirect:/apply/personal";
        }
        return "result";
    }

    // Optionally, complete the session
    @PostMapping("/apply/complete")
    public String completeApplication(SessionStatus status) {
        status.setComplete();
        return "redirect:/apply/personal";
    }
}
