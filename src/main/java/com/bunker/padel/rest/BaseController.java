package com.bunker.padel.rest;

import com.bunker.padel.model.JsonModel;
import com.bunker.padel.persistence.entity.BaseEntity;
import com.bunker.padel.service.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
public class BaseController <T extends BaseEntity,ID, DTO extends JsonModel> {

    protected final BaseService<T, ID, DTO> service;

    @GetMapping
    public ResponseEntity<List<DTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DTO> findById(@PathVariable ID id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<DTO> create(@RequestBody DTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DTO> update(@PathVariable ID id, @RequestBody DTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable ID id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
