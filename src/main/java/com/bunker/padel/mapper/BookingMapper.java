package com.bunker.padel.mapper;

import com.bunker.padel.model.BookingDTO;
import com.bunker.padel.persistence.entity.Booking;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookingMapper extends EntityMapper<Booking, BookingDTO> {
}
