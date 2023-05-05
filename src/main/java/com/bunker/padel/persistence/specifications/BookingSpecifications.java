package com.bunker.padel.persistence.specifications;

import com.bunker.padel.persistence.entity.Booking;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;

public class BookingSpecifications {

    public static Specification<Booking> dateTimeGreaterThan(final LocalDateTime dateTime) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            if(dateTime == null) {
                return null;
            }
            return  criteriaBuilder.greaterThan(root.get("dateTime"), dateTime);
        };
    }

    public static Specification<Booking> dateTimeLessThan(final LocalDateTime dateTime) {
        return (root, query, criteriaBuilder) -> {
            if(dateTime == null) {
                return null;
            }
            return criteriaBuilder.lessThan(root.get("dateTime"), dateTime);
        };
    }
}
