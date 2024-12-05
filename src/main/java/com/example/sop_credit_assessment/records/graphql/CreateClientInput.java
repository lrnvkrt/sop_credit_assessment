package com.example.sop_credit_assessment.records.graphql;

import com.example.sop_credit_assessment.models.Client;

public record CreateClientInput(
        String cif,
        String fullName,
        Integer age,
        String email,
        String annualIncome,
        String totalMonthlyDebtPayment,
        Client.EmploymentStatus employmentStatus
) {}
