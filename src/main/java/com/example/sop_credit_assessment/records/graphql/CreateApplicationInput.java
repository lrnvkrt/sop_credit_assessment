package com.example.sop_credit_assessment.records.graphql;

import com.example.sop_credit_assessment.models.Application;

public record CreateApplicationInput(
        String amount,
        Application.Purpose purpose,
        Integer term,
        String client
) {}

