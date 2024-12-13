package com.example.sop_credit_assessment.services.impl;

import com.example.sop_contracts.messages.CreditCheckVerificationMessage;
import com.example.sop_credit_assessment.services.ApplicationService;
import com.example.sop_credit_assessment.services.CreditVerificationListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreditVerificationListenerImpl implements CreditVerificationListener {
    private final ApplicationService applicationService;
    private static final Logger logger = LoggerFactory.getLogger(CreditVerificationListenerImpl.class);


    public CreditVerificationListenerImpl(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @Override
    @RabbitListener(queues = "creditUpdateStatusQueue")
    public void handle(CreditCheckVerificationMessage message) {
        logger.info("Received CreditCheckVerificationMessage");
        applicationService.updateStatus(UUID.fromString(message.referenceId()), message.applicationStatus());
    }
}
