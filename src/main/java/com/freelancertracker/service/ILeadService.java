package com.freelancertracker.service;

import com.freelancertracker.dto.LeadDTO;

import java.util.List;

public interface ILeadService {

    LeadDTO createLead(LeadDTO leadDTO, String userEmail);

    List<LeadDTO> getLeads(String userEmail);

    LeadDTO updateLeadStatus(Long id, String status);

    void deleteLead(Long id);
}
