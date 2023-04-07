package com.bunker.padel.model;

import com.bunker.padel.persistence.entity.Court;
import com.bunker.padel.persistence.entity.User;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookingDTO implements JsonDTO {

    private LocalDateTime dateTime;
    private Court court;
    private User user;
}
