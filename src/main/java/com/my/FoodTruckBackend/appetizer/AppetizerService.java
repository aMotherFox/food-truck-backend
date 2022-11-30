package com.my.FoodTruckBackend.appetizer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppetizerService {
    private final AppetizerRepository appetizerRepository;

    public Appetizer createNewAppetizers(NewAppetizerRequestBody newAppetizerRequestBody) {
        return appetizerRepository.createNewAppetizers(newAppetizerRequestBody);
    }
}
