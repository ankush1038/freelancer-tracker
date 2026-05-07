package com.freelancertracker.repository;

import com.freelancertracker.model.Lead;
import com.freelancertracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeadRepository extends JpaRepository<Lead, Long> {

    List<Lead> findByUser(User user);
}
