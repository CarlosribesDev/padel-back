package com.bunker.padel.mapper;

import com.bunker.padel.model.ScheduleDTO;
import com.bunker.padel.persistence.entity.Schedule;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ScheduleMapper extends EntityMapper<Schedule, ScheduleDTO> {
}
