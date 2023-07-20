package com.dex.repasaleatoire.repository;

import com.dex.repasaleatoire.model.Entree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntreeRepository extends JpaRepository<Entree, Long> {

    Entree findByNameEntree(String name);


}
