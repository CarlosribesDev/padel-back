package com.bunker.padel.auth;

import lombok.Data;

@Data
public class RegistrationRequest {
    private String name;
    private String surname;
    private String username;
    private String email;
    private String password;
}
