package com.my.FoodTruckBackend.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDto {
    private Integer id;
    private String firstName;
    //all fields except password
}
