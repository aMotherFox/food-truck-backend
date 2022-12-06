package com.my.FoodTruckBackend.appetizer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Appetizer {
    private Integer id;
    private String name;
    private Integer price;
}
