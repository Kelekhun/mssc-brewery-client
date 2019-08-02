package com.kapeed.msscbreweryclient.web.client;

import com.kapeed.msscbreweryclient.web.model.BeerDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class BreweryClientTest {

    private String apihost;

    @Autowired
    BreweryClient breweryClient;

    @Test
    void getBeerById() {
        BeerDTO beerDTO = breweryClient.getBeerById(UUID.randomUUID());
        assertNotNull(beerDTO);
        log.info("Value for BeerDTO is: " + beerDTO);
    }

    @Test
    void testSaveNewBeer(){
        BeerDTO beerDTO = BeerDTO
                .builder()
                .beerName("New Beer")
                .beerStyle("New Style")
                .build();

        URI uri = breweryClient.shaveNewBeer(beerDTO);
        log.info("Value for BeerDTO is: " + beerDTO);
        log.info("URI is not empty as well: " + uri);
        assertNotNull(beerDTO);
        assertNotNull(uri);
    }

    @Test
    void testUpdateBeer(){
        BeerDTO beerDTO = BeerDTO.builder().beerName("New Beer").build();

        breweryClient.updateBeer(UUID.randomUUID(), beerDTO);
        assertNotNull(beerDTO);
        log.info("Value for BeerDTO is: " + beerDTO);
    }

    @Test
    void testDeleteBeer() {
        breweryClient.deleteBeer(UUID.randomUUID());
        log.info("Deleted BeerDTO with id " + UUID.randomUUID().toString());
    }
}