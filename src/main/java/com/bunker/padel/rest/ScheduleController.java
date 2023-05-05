package com.bunker.padel.rest;

import com.bunker.padel.dto.ScheduleDTO;
import com.bunker.padel.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/schedule")
public class ScheduleController {
    private final ScheduleService scheduleService;

    @GetMapping
    public ResponseEntity<List<ScheduleDTO>> findAll() {
        return ResponseEntity.ok(this.scheduleService.findAll());
    }

    @PostMapping
    public ResponseEntity<ScheduleDTO> create(final @RequestBody ScheduleDTO scheduleDTO) {
        return ResponseEntity.ok(this.scheduleService.create(scheduleDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(final @PathVariable Long id) {
        this.scheduleService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
