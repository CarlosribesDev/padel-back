package com.bunker.padel.persistence.entity;

import com.bunker.padel.model.constants.CourtType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "court")
public class Court extends BaseEntity {

    private String name;

    @Enumerated(EnumType.STRING)
    private CourtType type;
}
