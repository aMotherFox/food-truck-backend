package com.my.FoodTruckBackend.appetizer;

import java.util.ArrayList;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AppetizerController {
    private final AppetizerService appetizerService;

    @PostMapping("/appetizers")
    public Appetizer createNewAppetizers(@RequestBody NewAppetizerRequestBody newAppetizerRequestBody) {
        return appetizerService.createNewAppetizers(newAppetizerRequestBody);
    }

    @GetMapping("/appetizer_menu")
    public ArrayList<Appetizer> getListOfAppetizers() {
        return appetizerService.getListOfAppetizers();
    }
}
