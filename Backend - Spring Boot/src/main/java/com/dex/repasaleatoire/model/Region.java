package com.dex.repasaleatoire.model;

import jakarta.persistence.*;


@Entity
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    // getters and setters
}

