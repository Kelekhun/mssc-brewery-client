package com.kapeed.msscbreweryclient.web.client;

import com.kapeed.msscbreweryclient.web.model.BeerDTO;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@ConfigurationProperties(prefix = "com.kapeed.brewery", ignoreUnknownFields = false)
@Component
public class BreweryClient {

    private final String BEER_PATH_V1 = "/api/v1/beer/";
    private String apihost;

    private final RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public BeerDTO getBeerById(UUID uuid){
        return restTemplate.getForObject(apihost+BEER_PATH_V1+uuid.toString(), BeerDTO.class);
    }

    public URI shaveNewBeer(BeerDTO beerDTO){
        return restTemplate.postForLocation(apihost + BEER_PATH_V1, beerDTO);
    }

    public void updateBeer(UUID beerId, BeerDTO beerDTO){
         restTemplate.put(apihost + BEER_PATH_V1 + beerId.toString(), beerDTO);

    }

    public void deleteBeer(UUID beerId){
        restTemplate.delete(apihost + BEER_PATH_V1 + beerId.toString());
    }

    public void setApihost(String apihost){
        this.apihost=apihost;
    }
}
