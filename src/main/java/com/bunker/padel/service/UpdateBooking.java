package com.bunker.padel.service;

import com.bunker.padel.persistence.entity.Booking;
import com.bunker.padel.persistence.entity.Court;
import com.bunker.padel.persistence.entity.Schedule;
import com.bunker.padel.persistence.repository.BookingRepository;
import com.bunker.padel.persistence.repository.CourtRepository;
import com.bunker.padel.persistence.specifications.BookingSpecifications;
import jakarta.transaction.Transactional;
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
//    @Scheduled(fixedRate = 10000)
    @Transactional
    public void createNewBookings() {
        final List<Court> courts = this.courtRepository.findAll();
        final LocalDate nextDate = LocalDate.now().plusDays(6L);
        this.deleteBookingsIfExist(nextDate);

        final List<Booking> bookings = new ArrayList<>();

        courts.forEach(court -> {
            final Schedule schedule = court.getSchedule();
            schedule.getHours().forEach(hour -> {
                final Booking booking = new Booking();
                booking.setCourt(court);
                booking.setDateTime(nextDate.atTime(hour));
                bookings.add(booking);
            });
        });

        this.bookingRepository.saveAll(bookings);
        // Lógica de tu proceso
        System.out.println("¡Mi proceso programado se ha ejecutado!");
    }

    private void deleteBookingsIfExist(final LocalDate date){
        final List<Booking> bookings = this.bookingRepository
                .findAll(BookingSpecifications.dateTimeGreaterThan(date.atStartOfDay()));

        this.bookingRepository.deleteAll(bookings);
    }
}
