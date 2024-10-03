package com.example.sop_credit_assessment.repositories;

import com.example.sop_credit_assessment.models.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, UUID> {

    List<Application> findAllByClientId(UUID uuid);
}
