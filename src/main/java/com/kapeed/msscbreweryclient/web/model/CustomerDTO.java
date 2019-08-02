package com.kapeed.msscbreweryclient.web.model;

import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class CustomerDTO {
    private UUID id;
    private String customerName;
    private String  address;
}

