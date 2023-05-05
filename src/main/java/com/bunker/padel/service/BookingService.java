package com.bunker.padel.service;

import com.bunker.padel.dto.BookingDTO;
import com.bunker.padel.params.BookingParams;

import java.util.List;

public interface BookingService {

    BookingDTO save(final BookingDTO userDTO);

    BookingDTO findById(final Long id);

    List<BookingDTO> findBySearch(final BookingParams params);

    void deleteById(final Long id);
}
