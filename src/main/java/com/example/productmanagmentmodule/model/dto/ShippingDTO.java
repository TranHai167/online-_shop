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
}
