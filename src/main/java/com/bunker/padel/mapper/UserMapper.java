package com.bunker.padel.mapper;

import com.bunker.padel.dto.UserDTO;
import com.bunker.padel.persistence.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = BookingMapper.class)
public interface UserMapper extends EntityMapper<User, UserDTO> {
}
