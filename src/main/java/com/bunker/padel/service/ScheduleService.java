package com.bunker.padel.service;

import com.bunker.padel.dto.ScheduleDTO;

import java.util.List;

public interface ScheduleService {

    List<ScheduleDTO> findAll();

    ScheduleDTO create(final ScheduleDTO scheduleDTO);

    void deleteById(final Long id);
}
