package com.bunker.padel.service.impl;

import com.bunker.padel.mapper.UserMapper;
import com.bunker.padel.dto.UserDTO;
import com.bunker.padel.params.UserParams;
import com.bunker.padel.persistence.entity.User;
import com.bunker.padel.persistence.repository.UserRepository;
import com.bunker.padel.persistence.specifications.UserSpecifications;
import com.bunker.padel.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDTO findById(final Long id) {
        final User user = this.userRepository.findById(id).orElse(null);
        return this.userMapper.entityToDTO(user);
    }

    @Override
    public List<UserDTO> findBySearch(final UserParams params) {
        final Specification<User> specification = UserSpecifications.byUsername(params.getUsernames());

        final List<User> users = this.userRepository.findAll(specification);
        return this.userMapper.entitiesToDTOs(users);
    }

    @Override
    public UserDTO create(final UserDTO userDTO) {
        final User user = this.userRepository.save(this.userMapper.DTOToEntity(userDTO));
        return this.userMapper.entityToDTO(user);
    }
}
