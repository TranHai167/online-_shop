package com.example.productmanagmentmodule.dto;

import com.example.productmanagmentmodule.model.EmailDetails;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;

@Data
//@Builder
@NoArgsConstructor
public class ShippingDTO {

    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    private EmailDetails email;

    @JsonProperty("addressLine")
    private String addressLine;

    @JsonProperty("city")
    private String city;
}
