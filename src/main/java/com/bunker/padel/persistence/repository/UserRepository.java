package com.bunker.padel.persistence.repository;

import com.bunker.padel.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    boolean existsByName(String name);

}

