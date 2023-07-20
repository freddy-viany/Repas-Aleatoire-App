package com.dex.repasaleatoire.service;

import com.dex.repasaleatoire.model.Dessert;
import com.dex.repasaleatoire.repository.DessertRepository;
import org.springframework.stereotype.Service;

@Service
public class DessertService {

    private DessertRepository dessertRepository;

    public DessertService(DessertRepository dessertRepository) {
        this.dessertRepository = dessertRepository;
    }

    public Dessert findById(Long dessertId) {

        Dessert dessert = dessertRepository.findById(dessertId).get();
        if(dessert!=null){
            return dessert;
        }

        return null;
    }

    public Dessert save(Dessert dessert) {

        dessertRepository.save(dessert);

        return dessert;
    }
}
