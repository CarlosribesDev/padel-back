package com.bunker.padel.persistence.repository;

import com.bunker.padel.persistence.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

    boolean existsByName(String name);

}

