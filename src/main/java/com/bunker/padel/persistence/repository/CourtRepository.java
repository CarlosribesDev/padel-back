package com.bunker.padel.persistence.repository;

import com.bunker.padel.persistence.entity.Court;
import org.springframework.stereotype.Repository;

@Repository
public interface CourtRepository extends BaseRepository<Court, Long> {
}
