package com.bunker.padel.model;

import com.bunker.padel.persistence.entity.Court;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookingDTO implements JsonDTO {

    private Long id;
    private LocalDateTime dateTime;
    private Court court;
    private long userId;
}
