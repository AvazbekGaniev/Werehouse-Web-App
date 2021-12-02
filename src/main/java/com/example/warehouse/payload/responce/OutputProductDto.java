package com.example.warehouse.payload.responce;

import lombok.Data;

@Data

public class OutputProductDto {
    private Integer productId;
    private Double amount;
    private Integer price;

}
