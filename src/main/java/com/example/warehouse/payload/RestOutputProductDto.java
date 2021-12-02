package com.example.warehouse.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestOutputProductDto {
    private String productName;

    private Double amount;

    private Integer price;

}
