package com.example.sop_credit_assessment.services;

import com.example.sop_credit_assessment.records.messages.CreditCheckRequestMessage;

public interface CreditCheckRequestSender {
    void sendCreditCheckRequest(CreditCheckRequestMessage message);
}
