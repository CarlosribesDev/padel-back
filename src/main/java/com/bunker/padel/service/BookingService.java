package com.bunker.padel.service;

import com.bunker.padel.mapper.BookingMapper;
import com.bunker.padel.model.BookingDTO;
import com.bunker.padel.persistence.entity.Booking;
import com.bunker.padel.persistence.repository.BookingRepository;
import com.bunker.padel.persistence.specifications.BookingSpecifications;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
public class BookingService extends BaseServiceImpl<Booking, Long, BookingDTO> {
    public BookingService(final BookingRepository bookingRepository, final BookingMapper bookingMapper) {
        super(bookingRepository, bookingMapper);
    }

    @Override
    public List<BookingDTO> findAll(final Map<String, String> filters) {
        Specification<Booking> specification = Specification.where(null);

        if(filters.containsKey("inDate")) {
            final LocalDate date = LocalDate.parse(filters.get("inDate"));
            specification = specification.and(
                    BookingSpecifications.dateTimeGreaterThan(date.atStartOfDay()).and(
                    BookingSpecifications.dateTimeLessThan(date.plusDays(1L).atStartOfDay())));
        }

        final List<Booking> entities = this.repository.findAll(specification);
        return this.entityMapper.entitiesToDTOs(entities);
    }
}
