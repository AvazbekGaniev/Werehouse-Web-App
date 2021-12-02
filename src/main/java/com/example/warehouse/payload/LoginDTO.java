package com.example.warehouse.payload;

import com.sun.istack.NotNull;
import lombok.Data;


@Data
public class LoginDTO {

    @NotNull
    private String userName;
    @NotNull
    private String password;
}
