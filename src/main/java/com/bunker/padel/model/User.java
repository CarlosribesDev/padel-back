package com.bunker.padel.model;

import lombok.Data;


@Data
public class User implements JsonModel {
    private Long id;
    private String name;
    private String surname;
    private String email;
}


