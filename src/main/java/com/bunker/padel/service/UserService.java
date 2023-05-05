package com.bunker.padel.service;

import com.bunker.padel.dto.UserDTO;
import com.bunker.padel.params.UserParams;

import java.util.List;

public interface UserService {

    UserDTO create(final UserDTO userDTO);

    UserDTO findById(final Long id);

    List<UserDTO> findBySearch(final UserParams params);
}
