package com.bunker.padel.service.impl;

import com.bunker.padel.mapper.ScheduleMapper;
import com.bunker.padel.dto.ScheduleDTO;
import com.bunker.padel.persistence.entity.Schedule;
import com.bunker.padel.persistence.repository.ScheduleRepository;
import com.bunker.padel.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final ScheduleMapper scheduleMapper;

    @Override
    public List<ScheduleDTO> findAll() {
        return this.scheduleMapper.entitiesToDTOs(this.scheduleRepository.findAll());
    }

    @Override
    public ScheduleDTO create(final ScheduleDTO scheduleDTO) {
        final Schedule schedule = this.scheduleMapper.DTOToEntity(scheduleDTO);
        return this.scheduleMapper.entityToDTO(schedule);
    }

    @Override
    public void deleteById(final Long id) {
        this.scheduleRepository.deleteById(id);
    }
}
