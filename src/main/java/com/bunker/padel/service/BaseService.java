package com.bunker.padel.service;

import com.bunker.padel.model.JsonModel;
import com.bunker.padel.persistence.entity.BaseEntity;

import java.util.List;

public interface BaseService<T extends BaseEntity, ID, DTO extends JsonModel> {
    List<DTO> findAll();
    DTO findById(ID id);
    DTO save(DTO dto);
    DTO update(ID id, DTO dto);
    void deleteById(ID id);
}