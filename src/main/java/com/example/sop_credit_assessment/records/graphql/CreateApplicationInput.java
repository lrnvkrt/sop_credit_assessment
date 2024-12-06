package com.example.sop_credit_assessment.records.graphql;

import com.example.sop_contracts.enumerations.Purpose;

public record CreateApplicationInput(
        String amount,
        Purpose purpose,
        Integer term,
        String client
) {}

