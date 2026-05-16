package com.freelancertracker.controller;

import com.freelancertracker.dto.LeadDTO;
import com.freelancertracker.service.ILeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leads")
public class LeadController {

    @Autowired
    private ILeadService leadService;

    @PostMapping
    public LeadDTO createLead(@RequestBody LeadDTO leadDTO, Authentication authentication){
        String userEmail = authentication.getName();

        return leadService.createLead(leadDTO, userEmail);
    }

    @GetMapping
    public List<LeadDTO> getLeads(Authentication authentication){

        String userEmail = authentication.getName();

        return leadService.getLeads(userEmail);
    }

    @PutMapping("/{id}")
    public LeadDTO updateLeadStatus(@PathVariable Long id, @RequestParam String status){

        return leadService.updateLeadStatus(id, status);

    }

    @DeleteMapping("{id}")
    public String deleteLead(@PathVariable Long id){

        leadService.deleteLead(id);

        return "Lead deleted successfully!";
    }
}
