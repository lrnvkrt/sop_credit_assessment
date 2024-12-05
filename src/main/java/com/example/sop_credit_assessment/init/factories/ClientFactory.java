package com.example.sop_credit_assessment.init.factories;

import com.example.sop_credit_assessment.dtos.ApplicationCreationDto;
import com.example.sop_credit_assessment.dtos.ClientDto;
import com.example.sop_credit_assessment.models.Application;
import com.example.sop_credit_assessment.models.Client;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class ClientFactory {
    private final Faker faker;

    private final Client.EmploymentStatus[] employmentStatuses = Client.EmploymentStatus.values();
    private final Application.Purpose[] purposes = Application.Purpose.values();

    public ClientFactory() { this.faker = new Faker(Locale.ENGLISH); }

    public ApplicationCreationDto createApplication(UUID client) {
        return new ApplicationCreationDto(
                BigDecimal.valueOf(faker.random().nextInt(100, 100000000)),
                purposes[faker.random().nextInt(0, purposes.length)-1],
                faker.random().nextInt(1, 360),
                client
        );
    }

    public ClientDto createClient() {
        return new ClientDto(
                faker.number().digits(10),
                faker.name().fullName(),
                faker.random().nextInt(18, 85),
                faker.internet().emailAddress(),
                BigDecimal.valueOf(faker.random().nextInt(100, 100000000)),
                BigDecimal.valueOf(faker.random().nextInt(0, 1000000)),
                employmentStatuses[faker.random().nextInt(0, employmentStatuses.length-1)]
        );
    }

    public List<ApplicationCreationDto> createApplications(int quantity, UUID client) {
        return IntStream.range(0, quantity).mapToObj(i -> createApplication(client)).collect(Collectors.toList());
    }

    public List<ClientDto> addClients(int quantity) {
        return IntStream.range(0, quantity).mapToObj(i -> createClient()).collect(Collectors.toList());
    }

    public Integer getRandomQuantity(int endQuantity) { return faker.random().nextInt(1, endQuantity); }

}
