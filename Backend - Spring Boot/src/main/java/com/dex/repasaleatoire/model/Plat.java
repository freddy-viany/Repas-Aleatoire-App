package com.dex.repasaleatoire.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Plat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String namePlat;

    private String ingredients;

    private String preparationPlat;

    private String image;

    // constructeurs, getters, setters, etc.
}
