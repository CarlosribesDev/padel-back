package com.bunker.padel.mapper;

import com.bunker.padel.model.CourtDTO;
import com.bunker.padel.persistence.entity.Court;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourtMapper extends EntityMapper<Court, CourtDTO> {
}
