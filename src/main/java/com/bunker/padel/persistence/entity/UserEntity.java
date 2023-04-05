package com.bunker.padel.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="APP_USER")
public class UserEntity extends BaseEntity {

    private String name;
    private String surname;
    private String email;
    private String password;
}
