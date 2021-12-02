package com.example.warehouse.payload.responce;

import lombok.Data;

@Data
public class InputProductDTO {
    private Integer productId;
    private double amount;
    private double price;
    private String expireDate;
}
