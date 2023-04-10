package com.bunker.padel.persistence.repository;

import com.bunker.padel.persistence.entity.BaseEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BaseRepository<T extends BaseEntity, ID> extends JpaRepository<T, ID> {
    List<T> findAll(Specification<T> specification);
}
