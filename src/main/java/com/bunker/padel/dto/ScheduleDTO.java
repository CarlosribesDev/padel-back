package com.bunker.padel.dto;


import lombok.Data;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class ScheduleDTO implements JsonDTO {

    private Long Id;
    private String name;
    private List<LocalTime> hours = new ArrayList<>();
}
