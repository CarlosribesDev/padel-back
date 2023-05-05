package com.bunker.padel.service;

import com.bunker.padel.dto.CourtDTO;

import java.util.List;

public interface CourtService {

    CourtDTO update(final Long id, final CourtDTO courtDTO);

    List<CourtDTO> findAll();
}
