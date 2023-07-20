package com.dex.repasaleatoire.controller;

import com.dex.repasaleatoire.model.*;
import com.dex.repasaleatoire.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@RestController
@RequestMapping("/api/meal")
@CrossOrigin("http://localhost:8080/")
public class MealController {



    private EntreeService entreeService;

    private PlatService platService;

    private DessertService dessertService;

    private MealService mealService;

    public MealController(EntreeService entreeService, PlatService platService,
                          DessertService dessertService, MealService mealService) {
        this.entreeService = entreeService;
        this.platService = platService;
        this.dessertService = dessertService;
        this.mealService = mealService;
    }

    @PostMapping("/addEntree")
    public ResponseEntity<Entree> addEntree(@RequestParam("file") MultipartFile file,
                                            @RequestParam("nameEntree") String nameEntree,
                                            @RequestParam("ingredients") String ingredients) throws IOException {

        Entree entree = new Entree();

        // Enregistrer l'image dans le dossier "images" et stocker le nom dans la propriété "image" de l'entree
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Path uploadPath = Paths.get("src/main/resources/static/images");
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
        try (InputStream inputStream = file.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
            entree.setImage(fileName);
        }

        entree.setNameEntree(nameEntree);
        entree.setIngredients(ingredients);


        Entree savedEntree = entreeService.save(entree);
        return ResponseEntity.ok(savedEntree);

    }

    @PostMapping("/addPlat")
    public ResponseEntity<Plat> addPlat(@RequestParam("file") MultipartFile file,
                                        @RequestParam("namePlat") String namePlat,
                                        @RequestParam("preparationPlat") String preparationPlat,
                                        @RequestParam("ingredients") String ingredients) throws IOException {

        Plat plat = new Plat();

        // Enregistrer l'image dans le dossier "images" et stocker le nom dans la propriété "image" du plat
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Path uploadPath = Paths.get("src/main/resources/static/images");
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
        try (InputStream inputStream = file.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
            plat.setImage(fileName);
        }

        plat.setNamePlat(namePlat);
        plat.setIngredients(ingredients);
        plat.setPreparationPlat(preparationPlat);


        Plat savedPlat = platService.save(plat);
        return ResponseEntity.ok(savedPlat);
    }

    @PostMapping("/addDessert")
    public ResponseEntity<Dessert> addDessert(@RequestParam("file") MultipartFile file,
                                              @RequestParam("nameDessert") String nameDessert,
                                              @RequestParam("ingredients") String ingredients) throws IOException{

        Dessert dessert = new Dessert();

        // Enregistrer l'image dans le dossier "images" et stocker le nom dans la propriété "image" du dessert
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Path uploadPath = Paths.get("src/main/resources/static/images");
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
        try (InputStream inputStream = file.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
            dessert.setImage(fileName);
        }

        dessert.setNameDessert(nameDessert);
        dessert.setIngredients(ingredients);




        Dessert savedDessert = dessertService.save(dessert);
        return new ResponseEntity<>(savedDessert, HttpStatus.OK);
    }


    @PostMapping("/addMeal")
    public ResponseEntity<Meal> addMeal(@RequestParam Long entreeId,
                                        @RequestParam Long platId,
                                        @RequestParam Long dessertId) {


        Entree entree = entreeService.findById(entreeId);
        Plat plat = platService.findById(platId);
        Dessert dessert = dessertService.findById(dessertId);

        Meal meal = new Meal();
        meal.setEntree(entree);
        meal.setPlat(plat);
        meal.setDessert(dessert);

        Meal savedMeal = mealService.save(meal);
        return ResponseEntity.ok(savedMeal);
    }






}
