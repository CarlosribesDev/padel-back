package com.bunker.padel.persistence.repository;

import com.bunker.padel.persistence.entity.Booking;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends BaseRepository<Booking, Long> {
}
