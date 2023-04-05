package com.bunker.padel.service.user;

import com.bunker.padel.mapper.UserMapper;
import com.bunker.padel.model.UserDTO;
import com.bunker.padel.persistence.entity.UserEntity;
import com.bunker.padel.persistence.repository.UserRepository;
import com.bunker.padel.service.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseServiceImpl<UserEntity, Long, UserDTO> {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    protected UserService(final UserRepository userRepository, final UserMapper userMapper) {
        super(userRepository, userMapper);
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }
}
