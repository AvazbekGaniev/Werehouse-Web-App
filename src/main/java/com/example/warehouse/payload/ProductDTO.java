package com.example.warehouse.payload;

import lombok.Data;

@Data
public class ProductDTO {
    private String name;
    private Integer catId;
    private Integer measureId;
    private Integer photoId;

}
