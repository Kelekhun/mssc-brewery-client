package com.kapeed.msscbreweryclient.web.client;

import com.kapeed.msscbreweryclient.web.model.CustomerDTO;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(prefix = "com.kapeed.customer", ignoreUnknownFields = false)
public class CustomerClient {

    private final String CUSTOMER_PATH_V1 = "/api/v1/customer/";
    private String apihost;

    private RestTemplate restTemplate;

    public CustomerClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public CustomerDTO getCustomerById(UUID customerId){

        return restTemplate.getForObject(apihost + CUSTOMER_PATH_V1 + customerId.toString(), CustomerDTO.class);

    }

    public URI shaveNewCustomer(CustomerDTO customerDTO){
        return restTemplate.postForLocation(apihost + CUSTOMER_PATH_V1, customerDTO);
    }

    public void updateCustomer(UUID customerId, CustomerDTO customerDTO){
        restTemplate.put(apihost + CUSTOMER_PATH_V1 + customerId.toString(), customerDTO);
    }

    public void deleteCustomer(UUID customerId){
        restTemplate.delete(apihost + CUSTOMER_PATH_V1 + customerId.toString());
    }

    public void setApihost(String apihost) {
        this.apihost = apihost;
    }
}
