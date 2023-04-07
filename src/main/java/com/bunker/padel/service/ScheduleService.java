package com.bunker.padel.service;

import com.bunker.padel.mapper.ScheduleMapper;
import com.bunker.padel.model.ScheduleDTO;
import com.bunker.padel.persistence.entity.Schedule;
import com.bunker.padel.persistence.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService extends BaseServiceImpl<Schedule, Long, ScheduleDTO> {

    public ScheduleService(final ScheduleRepository scheduleRepository,  final ScheduleMapper scheduleMapper) {
        super(scheduleRepository, scheduleMapper);
    }
}
