package com.dex.repasaleatoire.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Entree entree;

    @OneToOne
    private Plat plat;

    @OneToOne
    private Dessert dessert;


}

