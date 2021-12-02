package com.example.warehouse.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResInputProductDTO {

    private String productName;
    private Double amount;
    private Double price;
    private Date expireDate;

}
