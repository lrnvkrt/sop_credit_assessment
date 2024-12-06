package com.example.sop_credit_assessment.records.graphql;

import com.example.sop_contracts.enumerations.EmploymentStatus;

public record UpdateClientInput(
        String id,
        String cif,
        String fullName,
        Integer age,
        String email,
        String annualIncome,
        String totalMonthlyDebtPayment,
        EmploymentStatus employmentStatus
) {}
