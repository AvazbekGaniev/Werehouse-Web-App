package com.example.warehouse.payload.responce;

import lombok.Data;

import java.util.List;

@Data
public class InputDTO {
    //    private String date;
    private Integer warehouseId;
    private Integer currencyId;
    private String factureName;
    private Integer supplierId;

    private List<InputProductDTO> inputProductDTOS;
}
