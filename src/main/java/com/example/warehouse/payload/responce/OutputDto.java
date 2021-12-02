package com.example.warehouse.payload.responce;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutputDto {
    private Integer warehouseId;
    private Integer currencyId;
    private String factureNumber;
    private Integer clientId;

    private List<OutputProductDto>outputProductDtoList;
}
