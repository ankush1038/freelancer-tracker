package com.freelancertracker.dto;

public class DashboardDTO {

    private long totalLeads;

    private long sent;

    private long replied;

    private long viewed;

    private long rejected;

    private long converted;

    public DashboardDTO(long totalLeads, long converted, long rejected, long viewed, long sent, long replied) {
        this.totalLeads = totalLeads;
        this.converted = converted;
        this.rejected = rejected;
        this.viewed = viewed;
        this.sent = sent;
        this.replied = replied;
    }

    public long getTotalLeads() {
        return totalLeads;
    }

    public long getSent() {
        return sent;
    }

    public long getReplied() {
        return replied;
    }

    public long getViewed() {
        return viewed;
    }

    public long getConverted() {
        return converted;
    }

    public long getRejected() {
        return rejected;
    }
}
