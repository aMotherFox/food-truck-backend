package com.my.FoodTruckBackend.entree;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EntreeService {
    private final EntreeRepository entreeRepository;

    public Entree createNewEntree(EntreeRequestBody entreeRequestBody) {
        if (entreeRequestBody.getName().length() < 2 || entreeRequestBody.getName().length() > 150) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Please enter the entree's name, between 2-50 characters"
            );
        }
        return entreeRepository.createNewEntree(entreeRequestBody);
    }

    public List<Entree> gettingALLEntrees(){
        log.info("SELECTING ALL entrees");
        return entreeRepository.gettingAllEntree();
    }
}
