package com.dex.repasaleatoire.service;

import com.dex.repasaleatoire.model.Entree;
import com.dex.repasaleatoire.repository.EntreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class EntreeService {

    @Autowired
    private EntreeRepository entreeRepository;

    public Entree save(Entree entree) {

        entreeRepository.save(entree);
        return entree;

    }

    public Entree findById(Long entreeId) {

        Entree entree = entreeRepository.findById(entreeId).get();

        if (entree != null){
            return  entree;
        }

        return  null;
    }

    public Entree findByName(String name){
         Entree entree = entreeRepository.findByNameEntree(name);
        if (entree != null){
            return  entree;
        }

        return  null;
    }
}
