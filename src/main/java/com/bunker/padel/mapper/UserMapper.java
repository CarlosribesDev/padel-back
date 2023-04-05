package com.bunker.padel.mapper;

import com.bunker.padel.model.UserDTO;
import com.bunker.padel.persistence.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<UserEntity, UserDTO> {
}
