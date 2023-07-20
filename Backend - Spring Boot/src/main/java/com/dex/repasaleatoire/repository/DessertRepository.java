package com.dex.repasaleatoire.repository;

import com.dex.repasaleatoire.model.Dessert;
import com.dex.repasaleatoire.model.Plat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DessertRepository extends JpaRepository<Dessert,Long> {
  //  Dessert findRandomDessert();
}
