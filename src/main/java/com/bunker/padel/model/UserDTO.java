package com.bunker.padel.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements JsonDTO {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
}


