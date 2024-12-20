package com.automation.controller;

import com.automation.service.AutomationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/automation")
public class AutomationController {

    private final AutomationService automationService;

    public AutomationController(AutomationService automationService) {
        this.automationService = automationService;
    }

    @GetMapping("/project/{projectId}")
    public String runAutomation(
            @PathVariable String projectId,
            @RequestParam String username,
            @RequestParam String password) {
        try {
            automationService.performAutomation(projectId, username, password);
            return "Automation completed successfully";
        } catch (Exception e) {
            return "Automation failed: " + e.getMessage();
        }
    }
}