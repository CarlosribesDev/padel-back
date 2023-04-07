package com.bunker.padel.persistence.repository;

import com.bunker.padel.persistence.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
