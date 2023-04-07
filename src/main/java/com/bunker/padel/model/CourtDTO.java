package com.bunker.padel.model;

import com.bunker.padel.model.constants.CourtType;
import lombok.Data;

@Data
public class CourtDTO implements JsonDTO {

    private String id;
    private String name;
    private CourtType type;
}
