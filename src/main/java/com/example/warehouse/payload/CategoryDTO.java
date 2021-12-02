package com.example.warehouse.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
    //    private Integer id ;
    private String name;
    private Integer parentCategoryId;
    private boolean active = true;
//    private UUID createdBy;
//    private Timestamp createdAt;
//    private UUID updatedBy;
//    private Timestamp updatedAt;

}
