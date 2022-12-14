package com.my.FoodTruckBackend.entree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EntreeRequestBody {
    private String name;
    private String description;
    private Integer price;
}
