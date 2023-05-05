package com.bunker.padel.dto;

import com.bunker.padel.constants.CourtType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CourtDTO implements JsonDTO {

    private Long id;
    private String name;
    private CourtType type;
    private ScheduleDTO schedule;
    private BigDecimal price;
}
