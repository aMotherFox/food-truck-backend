package com.my.FoodTruckBackend.entree;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EntreeService {
    private final EntreeRepository entreeRepository;

    public EntreeDto createNewEntree(NewEntreeRequestBody newEntreeRequestBody) {
        return entreeRepository.createNewEntree(newEntreeRequestBody);
    }
}
