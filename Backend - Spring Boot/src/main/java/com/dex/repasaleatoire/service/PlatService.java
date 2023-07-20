package com.dex.repasaleatoire.service;

import com.dex.repasaleatoire.model.Entree;
import com.dex.repasaleatoire.model.Plat;
import com.dex.repasaleatoire.repository.PlatRepository;
import org.springframework.stereotype.Service;

@Service
public class PlatService {

    private PlatRepository platRepository;

    public PlatService(PlatRepository platRepository) {
        this.platRepository = platRepository;
    }

    public Plat findById(Long platId) {

        Plat plat = platRepository.findById(platId).get();

        if(plat!= null){
            return plat;
        }
        return null;
    }

    public Plat save(Plat plat) {

        platRepository.save(plat);
        return plat;
    }
}
