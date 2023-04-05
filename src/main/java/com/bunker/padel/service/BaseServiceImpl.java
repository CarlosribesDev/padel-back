package com.bunker.padel.service;

import com.bunker.padel.mapper.EntityMapper;
import com.bunker.padel.model.JsonModel;
import com.bunker.padel.persistence.entity.BaseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;



@RequiredArgsConstructor
public abstract class BaseServiceImpl<T extends BaseEntity, ID, DTO extends JsonModel> implements BaseService<T, ID, DTO> {
    private final JpaRepository<T, ID> repository;
    private final EntityMapper<T, DTO> entityMapper;

    @Override
    public List<DTO> findAll() {
        final List<T> entities = this.repository.findAll();
        return this.entityMapper.entitiesToModels(entities);
    }

    @Override
    public DTO findById(ID id) {
        final T entity = this.repository.findById(id).orElse(null);
        return this.entityMapper.entityToModel(entity);
    }

    @Override
    public DTO save(DTO dto) {
        final T entityToSave = this.entityMapper.modelToEntity(dto);
        final T entitySaved = this.repository.save(entityToSave);
        return this.entityMapper.entityToModel(entitySaved);
    }

    @Override
    public DTO update(ID id, DTO dto) {
        final T entityToSave = this.entityMapper.modelToEntity(dto);
        final T entitySaved = this.repository.save(entityToSave);
        return this.entityMapper.entityToModel(entitySaved);
    }

    @Override
    public void deleteById(ID id) {
        this.repository.deleteById(id);
    }
}
