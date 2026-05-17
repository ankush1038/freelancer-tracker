package com.freelancertracker.service;

import com.freelancertracker.dto.LeadDTO;
import com.freelancertracker.exception.ForbiddenException;
import com.freelancertracker.exception.ResourceNotFoundException;
import com.freelancertracker.model.Lead;
import com.freelancertracker.model.Status;
import com.freelancertracker.model.User;
import com.freelancertracker.repository.LeadRepository;
import com.freelancertracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LeadService implements ILeadService {

    @Autowired
    public LeadRepository leadRepository;

    @Autowired
    public UserRepository userRepository;


    // Create Lead
    @Override
    public LeadDTO createLead(LeadDTO leadDTO, String userEmail) {

        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User not found!"));

        Lead lead = new Lead();
        lead.setUser(user);
        lead.setPlatform(leadDTO.getPlatform());
        lead.setClientName(leadDTO.getClientName());
        lead.setProposalDate(LocalDate.now());
        lead.setStatus(Status.SENT);

        Lead savedLead = leadRepository.save(lead);

        return mapToDto(savedLead);
    }

    @Override
    public List<LeadDTO> getLeads(String userEmail) {

        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() ->new RuntimeException("User not found!"));

        List<Lead> leads = leadRepository.findByUser(user);

        return leads.stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    public LeadDTO updateLeadStatus(Long id, String status, String userEmail) {

        User currentUser = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new ResourceNotFoundException("User not Found!"));

        Lead lead = leadRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Lead not found!"));

        if(!lead.getUser().getId().equals(currentUser.getId())){

            throw new ForbiddenException("You ar not allowed to update this lead!");
        }

        lead.setStatus(Status.valueOf(status.toUpperCase()));

        Lead updatedLead = leadRepository.save(lead);
        return mapToDto(updatedLead);
    }

    @Override
    public void deleteLead(Long id) {

        Lead lead = leadRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Lead not found!"));

        leadRepository.delete(lead);

    }

    private LeadDTO mapToDto(Lead lead){

        return new LeadDTO(
                lead.getId(),
                lead.getStatus(),
                lead.getProposalDate(),
                lead.getPlatform(),
                lead.getClientName()
        );
    }
}
