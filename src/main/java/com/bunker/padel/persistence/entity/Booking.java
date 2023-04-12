package com.bunker.padel.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "booking", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"court_id", "date_time"})})
public class Booking extends BaseEntity {

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "court_id")
    private Court court;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}
