package com.bunker.padel.service.impl;

import com.bunker.padel.persistence.entity.Booking;
import com.bunker.padel.persistence.entity.Court;
import com.bunker.padel.persistence.repository.BookingRepository;
import com.bunker.padel.persistence.repository.CourtRepository;
import com.bunker.padel.persistence.specifications.BookingSpecifications;
import com.bunker.padel.service.BookingGenerator;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingGeneratorImpl implements BookingGenerator {

    private final CourtRepository courtRepository;
    private final BookingRepository bookingRepository;

    @Override
    @PostConstruct// Ejecuta el método cuando se crea la clase
    public void generateBookingsForWeek() {
        for (long i= 0; i <= 6L; i++){
            final LocalDate date = LocalDate.now().plusDays(i);

            if(this.getBookingsInDay(date).isEmpty()) {
                this.createBookingsInDay(date);
            }
        }
    }

    @Override
    @Scheduled(cron = "0 0 0 * * ?") // Expresión cron para ejecutar todos los días a medianoche
    public void createBookingsInLastDayOfWeek() {
        final LocalDate nextDate = LocalDate.now().plusDays(6);
        this.deleteBookingsInDay(nextDate);
        this.createBookingsInDay(nextDate);
    }

    private void createBookingsInDay(final LocalDate date) {
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
        final List<Booking> bookings = this.getBookingsInDay(date);
        this.bookingRepository.deleteAll(bookings);
    }

    private List<Booking> getBookingsInDay(final LocalDate date) {
        return  this.bookingRepository.findAll(
                        BookingSpecifications.dateTimeGreaterThan(date.atStartOfDay()).and(
                        BookingSpecifications.dateTimeLessThan(date.plusDays(1L).atStartOfDay()))
                );
    }
}
