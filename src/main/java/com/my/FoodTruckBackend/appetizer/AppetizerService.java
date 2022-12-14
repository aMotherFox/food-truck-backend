package com.my.FoodTruckBackend.appetizer;

import java.util.ArrayList;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class AppetizerService {
    private final AppetizerRepository appetizerRepository;

    public Appetizer createNewAppetizers(NewAppetizerRequestBody newAppetizerRequestBody) {
        if (newAppetizerRequestBody.getName().length() < 2 || newAppetizerRequestBody.getName().length() > 50) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Please enter the appetizer's name, between 2-50 characters"
            );
        }

        return appetizerRepository.createNewAppetizers(newAppetizerRequestBody);
    }

    public ArrayList<Appetizer> getListOfAppetizers() {
        return appetizerRepository.getListOfAppetizers();
    }
}
