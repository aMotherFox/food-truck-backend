package com.my.FoodTruckBackend.appetizer;

import java.util.ArrayList;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AppetizerController {
    private final AppetizerService appetizerService;

    @PostMapping("/appetizers")
    public Appetizer createNewAppetizers(@RequestBody NewAppetizerRequestBody newAppetizerRequestBody) {
        log.info("An appetizer is being created with RequestBody: " + newAppetizerRequestBody);
        return appetizerService.createNewAppetizers(newAppetizerRequestBody);
    }

    @GetMapping("/appetizers")
    public ArrayList<Appetizer> getListOfAppetizers() {
        log.info("Getting a list of all appetizers");
        return appetizerService.getListOfAppetizers();
    }

    @GetMapping("/appetizers/{id}")
    public Appetizer getAppetizerById(@PathVariable Integer id) {
        log.info("Getting appetizer by id");
        return appetizerService.getAppetizerById(id);
    }
}
