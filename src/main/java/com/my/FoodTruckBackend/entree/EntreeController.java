package com.my.FoodTruckBackend.entree;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/entree")
    public List<Entree> getALLEntrees() {
        log.info("Getting ALL entrees");
        return entreeService.gettingALLEntrees();
    }
    @GetMapping("/entrees/{id}")
    public Entree gettingEntreeById(@PathVariable Integer id) {
        return entreeService.gettingEntreeById(id);
    }
}
