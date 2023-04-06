package com.bunker.padel.model;

import lombok.Data;


@Data
public class UserDTO implements JsonDTO {
    private Long id;
    private String name;
    private String surname;
    private String username;
    private String email;
    private String password;
    private Role role;
}


