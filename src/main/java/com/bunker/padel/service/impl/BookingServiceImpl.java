package com.bunker.padel.service.impl;

import com.bunker.padel.mapper.BookingMapper;
import com.bunker.padel.model.BookingDTO;
import com.bunker.padel.params.BookingParams;
import com.bunker.padel.persistence.entity.Booking;
import com.bunker.padel.persistence.repository.BookingRepository;
import com.bunker.padel.persistence.specifications.BookingSpecifications;
import com.bunker.padel.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;


    @Override
    public BookingDTO save(BookingDTO userDTO) {
        final Booking booking = this.bookingRepository.save(this.bookingMapper.DTOToEntity(userDTO));
        return this.bookingMapper.entityToDTO(booking);
    }

    @Override
    public BookingDTO findById(Long id) {
        final Booking booking = this.bookingRepository.findById(id).orElse(null);
        return this.bookingMapper.entityToDTO(booking);
    }

    @Override
    public List<BookingDTO> findBySearch(BookingParams params) {
        final LocalDate date = params.getInDate();
        final Specification<Booking> specification =
                BookingSpecifications.dateTimeGreaterThan(date == null ? null : date.atStartOfDay()).and(
                BookingSpecifications.dateTimeLessThan(date == null ? null : date.plusDays(1L).atStartOfDay()));

        final List<Booking> entities = this.bookingRepository.findAll(specification);
        return this.bookingMapper.entitiesToDTOs(entities);
    }

    @Override
    public void deleteById(Long id) {
        this.bookingRepository.deleteById(id);
    }
}
