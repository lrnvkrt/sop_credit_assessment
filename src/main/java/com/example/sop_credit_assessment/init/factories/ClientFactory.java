package com.example.sop_credit_assessment.init.factories;

import com.example.sop_contracts.enumerations.EmploymentStatus;
import com.example.sop_contracts.enumerations.Purpose;
import com.example.sop_contracts.requests.ApplicationCreationRequest;
import com.example.sop_contracts.requests.ClientRequest;
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

    private final EmploymentStatus[] employmentStatuses = EmploymentStatus.values();
    private final Purpose[] purposes = Purpose.values();

    public ClientFactory() { this.faker = new Faker(Locale.ENGLISH); }

    public ApplicationCreationRequest createApplication(UUID client) {
        return new ApplicationCreationRequest(
                BigDecimal.valueOf(faker.random().nextInt(100, 100000000)),
                purposes[faker.random().nextInt(1, purposes.length)-1],
                faker.random().nextInt(1, 360),
                client
        );
    }

    public ClientRequest createClient() {
        return new ClientRequest(
                faker.number().digits(10),
                faker.name().fullName(),
                faker.random().nextInt(18, 85),
                faker.internet().emailAddress(),
                BigDecimal.valueOf(faker.random().nextInt(100, 100000000)),
                BigDecimal.valueOf(faker.random().nextInt(0, 1000000)),
                employmentStatuses[faker.random().nextInt(0, employmentStatuses.length-1)]
        );
    }

    public List<ApplicationCreationRequest> createApplications(int quantity, UUID client) {
        return IntStream.range(0, quantity).mapToObj(i -> createApplication(client)).collect(Collectors.toList());
    }

    public List<ClientRequest> addClients(int quantity) {
        return IntStream.range(0, quantity).mapToObj(i -> createClient()).collect(Collectors.toList());
    }

    public Integer getRandomQuantity(int endQuantity) { return faker.random().nextInt(1, endQuantity); }

}
