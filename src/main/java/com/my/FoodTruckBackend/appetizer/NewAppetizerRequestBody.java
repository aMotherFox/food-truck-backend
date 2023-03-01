package com.my.FoodTruckBackend.appetizer;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NewAppetizerRequestBody {
    private String name;
    private String description;
    private Integer price;
}
