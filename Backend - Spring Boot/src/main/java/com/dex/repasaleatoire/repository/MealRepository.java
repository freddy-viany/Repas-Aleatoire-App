package com.dex.repasaleatoire.repository;

import com.dex.repasaleatoire.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MealRepository extends JpaRepository<Meal,Long> {


    }


