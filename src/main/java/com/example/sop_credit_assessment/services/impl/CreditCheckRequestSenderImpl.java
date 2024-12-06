package com.example.sop_credit_assessment.services.impl;

import com.example.sop_credit_assessment.records.messages.CreditCheckRequestMessage;
import com.example.sop_credit_assessment.services.CreditCheckRequestSender;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class CreditCheckRequestSenderImpl implements CreditCheckRequestSender {

    private final RabbitTemplate rabbitTemplate;
    static final String exchangeName = "applicationExchange";

    public CreditCheckRequestSenderImpl(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void sendCreditCheckRequest(CreditCheckRequestMessage message) {
//        rabbitTemplate.convertAndSend(exchangeName, "application.creation", message);
    }
}
