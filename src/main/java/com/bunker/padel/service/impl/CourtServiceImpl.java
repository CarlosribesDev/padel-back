package com.bunker.padel.service.impl;

import com.bunker.padel.mapper.CourtMapper;
import com.bunker.padel.dto.CourtDTO;
import com.bunker.padel.persistence.entity.Court;
import com.bunker.padel.persistence.repository.CourtRepository;
import com.bunker.padel.service.CourtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourtServiceImpl implements CourtService {

    private final CourtRepository courtRepository;
    private final CourtMapper courtMapper;

    @Override
    public CourtDTO update(final Long id, final CourtDTO courtDTO) {
        Assert.isTrue(id.equals(courtDTO.getId()), "ID in the DTO does not match the provided ID.");

        final Court court = this.courtRepository.save(this.courtMapper.DTOToEntity(courtDTO));
        return this.courtMapper.entityToDTO(court);
    }

    @Override
    public List<CourtDTO> findAll() {
        return this.courtMapper.entitiesToDTOs(this.courtRepository.findAll());
    }
}
