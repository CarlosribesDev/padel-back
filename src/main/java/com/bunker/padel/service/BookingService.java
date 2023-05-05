package com.bunker.padel.service;

import com.bunker.padel.dto.BookingDTO;
import com.bunker.padel.params.BookingParams;

import java.util.List;

public interface BookingService {

    List<BookingDTO> findBySearch(final BookingParams params);

    BookingDTO update(final Long id, final BookingDTO userDTO);

    void deleteById(final Long id);
}
