package com.dex.repasaleatoire.service;

import com.dex.repasaleatoire.model.Dessert;
import com.dex.repasaleatoire.model.Entree;
import com.dex.repasaleatoire.model.Plat;
import com.dex.repasaleatoire.model.Meal;
import com.dex.repasaleatoire.repository.DessertRepository;
import com.dex.repasaleatoire.repository.EntreeRepository;
import com.dex.repasaleatoire.repository.PlatRepository;
import com.dex.repasaleatoire.repository.MealRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MealService {

    private EntreeRepository entreeRepository;
    private PlatRepository platRepository;
    private DessertRepository dessertRepository;
    private MealRepository mealRepository;


    public MealService(EntreeRepository entreeRepository, PlatRepository platRepository,
                       DessertRepository dessertRepository, MealRepository mealRepository) {
        this.entreeRepository = entreeRepository;
        this.platRepository = platRepository;
        this.dessertRepository = dessertRepository;
        this.mealRepository = mealRepository;
    }



    public List<Meal> generateMealWeek() {

        // Créer une liste de tous les plats, entrées et desserts disponibles
        List<Plat> plats = platRepository.findAll();
        List<Entree> entrees = entreeRepository.findAll();
        List<Dessert> desserts = dessertRepository.findAll();

        // Stocker les combinaisons déjà utilisées
        List<String> usedCombinations = new ArrayList<>();

       // Générer des repas pour chaque jour de la semaine
        List<Meal> repasSemaine = new ArrayList<>();
        // Générer des repas pour chaque jour de la semaine
        for (int i = 0; i < 7; i++) {
            boolean uniqueCombination = false;
            Plat plat = null;
            Entree entree = null;
            Dessert dessert = null;

            // Générer une combinaison unique pour chaque jour de la semaine
            while (!uniqueCombination) {
                // Choisir aléatoirement un plat, une entrée et un dessert parmi la liste
                plat = plats.get(new Random().nextInt(plats.size()));
                entree = entrees.get(new Random().nextInt(entrees.size()));
                dessert = desserts.get(new Random().nextInt(desserts.size()));

                // Vérifier si la combinaison a déjà été utilisée
                String combination = plat.getNamePlat() + entree.getNameEntree() + dessert.getNameDessert();
                if (!usedCombinations.contains(combination)) {
                    usedCombinations.add(combination);
                    uniqueCombination = true;
                }
            }

            // Enregistrer la combinaison unique pour le jour de la semaine
            Meal meal = new Meal();
            meal.setDessert(dessert);
            meal.setEntree(entree);
            meal.setPlat(plat);

            mealRepository.save(meal);

            // Ajouter le repas à la liste de la semaine
            repasSemaine.add(meal);
        }

        return repasSemaine;



    }



    public List<Meal> getListeRepas() {
        return mealRepository.findAll();
    }

    public void ajouterRepas(Meal meal) {
        mealRepository.save(meal);
    }

    public void modifierRepas(Meal meal) {
        mealRepository.save(meal);
    }

    public void supprimerRepas(Long id) {
        mealRepository.deleteById(id);
    }


    public Meal save(Meal meal) {

        mealRepository.save(meal);
        return meal;
    }


}

