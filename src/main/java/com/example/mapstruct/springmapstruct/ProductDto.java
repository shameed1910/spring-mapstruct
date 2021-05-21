package com.example.mapstruct.springmapstruct;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {

    private int id;
    private String desc;
    private String price;
    private String quantity;
}
