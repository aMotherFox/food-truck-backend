package com.my.FoodTruckBackend.order;

import com.my.FoodTruckBackend.appetizer.Appetizer;
import com.my.FoodTruckBackend.entree.Entree;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDTO {

    private Integer id;
    private Integer customerId;
    private List<Entree> entrees;
    private List<Appetizer> appetizers;
}
