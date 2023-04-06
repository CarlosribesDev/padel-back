package com.bunker.padel.persistence.entity;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name="APP_USER")
public class User extends BaseEntity {

    private String name;
    private String surname;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String email;


}
