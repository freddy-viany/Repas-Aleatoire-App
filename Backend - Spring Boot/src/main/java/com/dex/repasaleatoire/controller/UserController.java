package com.dex.repasaleatoire.controller;

import com.dex.repasaleatoire.model.Meal;
import com.dex.repasaleatoire.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/meal")
@CrossOrigin("http://localhost:8080/")
public class UserController {

    @Autowired
    private MealService mealService;


    @GetMapping("/generer-repas-week")
    public List<Meal> generateMeal7Days() {

        return mealService.generateMealWeek();
    }



}

