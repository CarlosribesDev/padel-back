package com.bunker.padel.mapper;

import com.bunker.padel.dto.BookingDTO;
import com.bunker.padel.persistence.entity.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookingMapper extends EntityMapper<Booking, BookingDTO> {

    @Override
    @Mapping(source = "user.id", target = "userId")
    BookingDTO entityToDTO(Booking booking);

    @Override
    @Mapping(source = "userId", target = "user.id")
    Booking DTOToEntity(BookingDTO bookingDTO);
}
