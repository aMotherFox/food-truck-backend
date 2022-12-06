package com.my.FoodTruckBackend.entree;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class EntreeController {
    private final EntreeService entreeService;

    @PostMapping("/entree")
    public Entree createNewEntree(@RequestBody EntreeRequestBody entreeRequestBody) {
        log.info("creating new entree");
        return entreeService.createNewEntree(entreeRequestBody);
    }
}
