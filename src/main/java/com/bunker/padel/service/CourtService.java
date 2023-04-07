package com.bunker.padel.service;

import com.bunker.padel.mapper.CourtMapper;
import com.bunker.padel.model.CourtDTO;
import com.bunker.padel.persistence.entity.Court;
import com.bunker.padel.persistence.repository.CourtRepository;
import org.springframework.stereotype.Service;

@Service
public class CourtService extends BaseServiceImpl <Court, Long, CourtDTO> {

    public CourtService(final CourtRepository repository,final CourtMapper courtMapper) {
        super(repository, courtMapper);
    }
}
