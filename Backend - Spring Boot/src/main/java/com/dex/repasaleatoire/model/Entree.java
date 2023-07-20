package com.dex.repasaleatoire.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Entree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameEntree;

    private String ingredients;

    private String image;

    // constructeurs, getters, setters, etc.
}
