package com.bunker.padel.rest;

import com.bunker.padel.model.BookingDTO;
import com.bunker.padel.persistence.entity.Booking;
import com.bunker.padel.service.BookingService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking")
public class BookingController extends BaseController<Booking, Long, BookingDTO> {
    public BookingController(final BookingService bookingService) {
        super(bookingService);
    }
}
