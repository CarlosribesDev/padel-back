package com.bunker.padel.service;

import com.bunker.padel.model.BookingDTO;
import com.bunker.padel.params.BookingParams;

import java.util.List;

public interface BookingService {

    BookingDTO save(BookingDTO userDTO);

    BookingDTO findById(Long id);

    List<BookingDTO> findBySearch(BookingParams params);

    void deleteById(Long id);
}
