package com.bunker.padel.persistence.specifications;

import com.bunker.padel.persistence.entity.Booking;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;

public class BookingSpecifications {

    public static Specification<Booking> dateTimeGreaterThan(final LocalDateTime dateTime) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.greaterThan(root.get("dateTime"), dateTime);
    }
}
