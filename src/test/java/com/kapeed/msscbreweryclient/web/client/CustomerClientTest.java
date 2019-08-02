package com.kapeed.msscbreweryclient.web.client;

import com.kapeed.msscbreweryclient.web.model.CustomerDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@Slf4j
@SpringBootTest
class CustomerClientTest {

    @Autowired
    CustomerClient customerClient;

    @Test
    void getCustomerById() {

        CustomerDTO customerDTO = customerClient.getCustomerById(UUID.randomUUID());
        assertNotNull(customerDTO);
        log.info("Value for CustomerDTO is: " + customerDTO);
    }

    @Test
    void shaveNewCustomer() {

        CustomerDTO customerDTO = CustomerDTO
                .builder()
                .customerName("Sony Khadka")
                .address("Kathmandu Nepal")
                .build();

        URI uri = customerClient.shaveNewCustomer(customerDTO);
        log.info("Value for CustomerDTO is: " + customerDTO);
        log.info("URI is not empty as well: " + uri);

        assertNotNull(customerDTO);
        assertNotNull(uri);
    }

    @Test
    void updateCustomer() {

        CustomerDTO customerDTO = CustomerDTO
                .builder()
                .customerName("Suresh Khadka")
                .address("Balaju Nepal")
                .build();

        customerClient.updateCustomer(UUID.randomUUID(), customerDTO);
        assertNotNull(customerDTO);
        log.info("Value for CustomerDTO is: " + customerDTO);
    }

    @Test
    void deleteCustomer() {
        customerClient.deleteCustomer(UUID.randomUUID());
        log.info("Deleted CustomerDTO with customerID: " + UUID.randomUUID().toString());
    }
}