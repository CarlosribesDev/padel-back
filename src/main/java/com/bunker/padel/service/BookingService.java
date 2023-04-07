package com.bunker.padel.service;

import com.bunker.padel.mapper.BookingMapper;
import com.bunker.padel.model.BookingDTO;
import com.bunker.padel.persistence.entity.Booking;
import com.bunker.padel.persistence.repository.BookingRepository;
import org.springframework.stereotype.Service;

@Service
public class BookingService extends BaseServiceImpl<Booking, Long, BookingDTO> {
    public BookingService(final BookingRepository bookingRepository, final BookingMapper bookingMapper) {
        super(bookingRepository, bookingMapper);
    }
}
