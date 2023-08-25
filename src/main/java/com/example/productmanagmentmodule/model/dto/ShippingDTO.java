package com.example.productmanagmentmodule.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShippingDTO {
    private String name;

    private String addressLine1;

    private String addressLine2;

    private String city;

    private String numberPhone;

    private EmailDetails email;

    public ShippingDTO(String name, String addressLine1, String addressLine2, String city) {
        this.name = name;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
    }
}
