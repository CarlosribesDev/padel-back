package com.bunker.padel.rest;

import com.bunker.padel.model.ScheduleDTO;
import com.bunker.padel.persistence.entity.Schedule;
import com.bunker.padel.service.ScheduleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schedule")
public class ScheduleController extends BaseController<Schedule, Long, ScheduleDTO> {
    public ScheduleController(ScheduleService service) {
        super(service);
    }
}
