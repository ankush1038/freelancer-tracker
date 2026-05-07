package com.freelancertracker.dto;

import com.freelancertracker.model.Status;

import java.time.LocalDate;

public class LeadDTO {

    private Long id;
    private String clientName;
    private String platform;
    private LocalDate proposalDate;
    private Status status;

    public LeadDTO(Long id, Status status, LocalDate proposalDate, String platform, String clientName) {
        this.id = id;
        this.status = status;
        this.proposalDate = proposalDate;
        this.platform = platform;
        this.clientName = clientName;
    }

    public LeadDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getProposalDate() {
        return proposalDate;
    }

    public void setProposalDate(LocalDate proposalDate) {
        this.proposalDate = proposalDate;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
}
