package com.bunker.padel.rest;

import com.bunker.padel.model.CourtDTO;
import com.bunker.padel.persistence.entity.Court;
import com.bunker.padel.service.CourtService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/court")
public class CourtController extends BaseController <Court, Long, CourtDTO> {
    public CourtController(final CourtService courtService) {
        super(courtService);
    }
}
