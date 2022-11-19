package com.my.FoodTruckBackend.entree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Entree {
    private Integer id;
    private String name;
    private String description;
    private String price;
}
