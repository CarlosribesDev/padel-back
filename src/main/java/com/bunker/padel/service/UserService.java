package com.bunker.padel.service;

import com.bunker.padel.model.UserDTO;
import com.bunker.padel.params.UserParams;

import java.util.List;

public interface UserService {

    UserDTO save(UserDTO userDTO);

    UserDTO findById(Long id);

    List<UserDTO> findBySearch(UserParams params);
}
