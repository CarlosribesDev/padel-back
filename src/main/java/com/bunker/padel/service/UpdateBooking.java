package com.bunker.padel.service;

import com.bunker.padel.persistence.entity.Booking;
import com.bunker.padel.persistence.entity.Court;
import com.bunker.padel.persistence.repository.BookingRepository;
import com.bunker.padel.persistence.repository.CourtRepository;
import com.bunker.padel.persistence.specifications.BookingSpecifications;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UpdateBooking {

    private final CourtRepository courtRepository;
    private final BookingRepository bookingRepository;


    @Scheduled(cron = "0 0 0 * * ?") // Expresión cron para ejecutar todos los días a medianoche
  //  @Scheduled(fixedRate = 30000)
    public void createBookingsForNextDay() {

        for (long i= 0; i <= 6L; i++){
            final LocalDate nextDate = LocalDate.now().plusDays(i);
            this.deleteBookingsInDay(nextDate);
            this.createBookingsInDay(nextDate);
        }
    }

    public void createBookingsInDay(final LocalDate date) {
        final List<Court> courts = this.courtRepository.findAll();
        final List<Booking> bookings = new ArrayList<>();

        courts.forEach(court ->
            court.getSchedule().getHours().forEach(hour -> {
                final Booking booking = new Booking();
                booking.setCourt(court);
                booking.setDateTime(date.atTime(hour));
                bookings.add(booking);
            })
        );

        this.bookingRepository.saveAll(bookings);
    }

    private void deleteBookingsInDay(final LocalDate date) {
        final List<Booking> bookings = this.bookingRepository
            .findAll(
                BookingSpecifications.dateTimeGreaterThan(date.atStartOfDay()).and(
                BookingSpecifications.dateTimeLessThan(date.plusDays(1L).atStartOfDay()))
            );

        this.bookingRepository.deleteAll(bookings);
    }
}
