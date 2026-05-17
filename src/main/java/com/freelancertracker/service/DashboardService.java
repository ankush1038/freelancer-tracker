package com.freelancertracker.service;

import com.freelancertracker.dto.DashboardDTO;
import com.freelancertracker.exception.ResourceNotFoundException;
import com.freelancertracker.model.Lead;
import com.freelancertracker.model.Status;
import com.freelancertracker.model.User;
import com.freelancertracker.repository.LeadRepository;
import com.freelancertracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardService implements IDashboardService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LeadRepository leadRepository;

    @Override
    public DashboardDTO getDashboardData(String userEmail) {

        // Fetch current user
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found"));

        // Fetch user's leads
        List<Lead> leads = leadRepository.findByUser(user);

        // Analytics

        long totalLeads = leads.size();

        long sent = leads.stream()
                .filter(lead -> lead.getStatus() == Status.SENT)
                .count();

        long viewed = leads.stream()
                .filter(lead -> lead.getStatus() == Status.VIEWED)
                .count();

        long replied = leads.stream()
                .filter(lead -> lead.getStatus() == Status.REPLIED)
                .count();

        long rejected = leads.stream()
                .filter(lead -> lead.getStatus() == Status.REJECTED)
                .count();

        long converted = leads.stream()
                .filter(lead -> lead.getStatus() == Status.CONVERTED)
                .count();

        return new DashboardDTO(
                totalLeads,
                sent,
                viewed,
                replied,
                rejected,
                converted
        );
    }
}
