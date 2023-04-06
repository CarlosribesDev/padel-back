package com.bunker.padel.persistence.repository;

import com.bunker.padel.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}

