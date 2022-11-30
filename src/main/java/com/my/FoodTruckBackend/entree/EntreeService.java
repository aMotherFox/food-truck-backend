package com.my.FoodTruckBackend.entree;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EntreeService {
    private final EntreeRepository entreeRepository;

    public Entree createNewEntree(EntreeRequestBody entreeRequestBody) {
        return entreeRepository.createNewEntree(entreeRequestBody);
    }

    public List<Entree> gettingALLEntrees(){
        log.info("SELECTING ALL entrees");
        return entreeRepository.gettingAllEntree();
    }
}
