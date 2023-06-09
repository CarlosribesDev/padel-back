package com.bunker.padel.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "schedule")
public class Schedule extends BaseEntity {

    private String name;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "schedule_hours", joinColumns = @JoinColumn(name = "schedule_id"))
    @Column(name = "hour")
    private List<LocalTime> hours = new ArrayList<>();
}
