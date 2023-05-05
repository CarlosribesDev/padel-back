package com.bunker.padel.params;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class BookingParams implements Serializable {
    private LocalDate inDate;
}
