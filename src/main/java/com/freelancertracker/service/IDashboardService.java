package com.freelancertracker.service;

import com.freelancertracker.dto.DashboardDTO;

public interface IDashboardService {

    DashboardDTO getDashboardData(String userEmail);
}
