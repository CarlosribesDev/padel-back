package com.bunker.padel.service;

import com.bunker.padel.mapper.UserMapper;
import com.bunker.padel.model.UserDTO;
import com.bunker.padel.persistence.entity.User;
import com.bunker.padel.persistence.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseServiceImpl<User, Long, UserDTO> {

    protected UserService(final UserRepository userRepository, final UserMapper userMapper) {
        super(userRepository, userMapper);
    }
}
