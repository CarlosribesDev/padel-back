package com.bunker.padel.service;

import com.bunker.padel.mapper.EntityMapper;
import com.bunker.padel.model.JsonDTO;
import com.bunker.padel.persistence.entity.BaseEntity;
import com.bunker.padel.persistence.repository.BaseRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;


@RequiredArgsConstructor
public abstract class BaseServiceImpl<T extends BaseEntity, ID, DTO extends JsonDTO> implements BaseService<T, ID, DTO> {
    protected final BaseRepository<T, ID> repository;
    protected final EntityMapper<T, DTO> entityMapper;

    @Override
    public List<DTO> findAll(Map<String, String> filers) {
        final List<T> entities = this.repository.findAll();
        return this.entityMapper.entitiesToDTOs(entities);
    }

    @Override
    public DTO findById(ID id) {
        final T entity = this.repository.findById(id).orElse(null);
        return this.entityMapper.entityToDTO(entity);
    }

    @Override
    public DTO save(DTO dto) {
        final T entityToSave = this.entityMapper.DTOToEntity(dto);
        final T entitySaved = this.repository.save(entityToSave);
        return this.entityMapper.entityToDTO(entitySaved);
    }

    @Override
    public DTO update(ID id, DTO dto) {
        final T entityToSave = this.entityMapper.DTOToEntity(dto);
        final T entitySaved = this.repository.save(entityToSave);
        return this.entityMapper.entityToDTO(entitySaved);
    }

    @Override
    public void deleteById(ID id) {
        this.repository.deleteById(id);
    }
}
