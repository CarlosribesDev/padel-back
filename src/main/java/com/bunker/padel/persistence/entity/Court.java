package com.bunker.padel.persistence.entity;

import com.bunker.padel.constants.CourtType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "court")
public class Court extends BaseEntity {

    private String name;

    @Enumerated(EnumType.STRING)
    private CourtType type;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    private BigDecimal price;

}
