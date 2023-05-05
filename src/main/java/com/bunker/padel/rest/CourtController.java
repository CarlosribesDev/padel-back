package com.bunker.padel.rest;

import com.bunker.padel.dto.CourtDTO;
import com.bunker.padel.service.CourtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/court")
public class CourtController {

    private final CourtService courtService;

    @GetMapping
    public ResponseEntity<List<CourtDTO>> findAll() {
        return ResponseEntity.ok(this.courtService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CourtDTO> update(final @PathVariable Long id, final @RequestBody CourtDTO courtDTO) {
        return ResponseEntity.ok(this.courtService.update(id, courtDTO));
    }
}
