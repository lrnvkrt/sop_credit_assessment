package com.example.sop_credit_assessment.services;

import com.example.sop_contracts.messages.CreditCheckVerificationMessage;

public interface CreditVerificationListener {
    void handle(CreditCheckVerificationMessage message);
}
