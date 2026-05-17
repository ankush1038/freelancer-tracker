package com.freelancertracker.controller;

import com.freelancertracker.dto.DashboardDTO;
import com.freelancertracker.service.IDashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dashboard")
public class DashBoardController {

    @Autowired
    private IDashboardService dashboardService;

    @GetMapping
    public DashboardDTO getDashboardData(Authentication authentication){

        String userEmail = authentication.getName();

        return dashboardService.getDashboardData(userEmail);
    }
}
