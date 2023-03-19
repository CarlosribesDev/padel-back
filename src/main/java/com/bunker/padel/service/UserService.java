package com.bunker.padel.service;

import com.bunker.padel.mapper.UserMapper;
import com.bunker.padel.model.User;
import com.bunker.padel.persistence.entity.UserEntity;
import com.bunker.padel.persistence.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<User> getAllUsers() {
        return this.userMapper.entitiesToModels(this.userRepository.findAll());
    }

    public User getUserById(final Long id) {
        Assert.isTrue(this.userRepository.existsById(id), "User not exist");
        final UserEntity userEntity = this.userRepository.findById(id).orElseThrow();
        return this.userMapper.entityToModel(userEntity);
    }

    public User updateUser(final Long id, final User user) {
        Assert.isTrue(id.equals(user.getId()), "the ids do not match ");
        Assert.isTrue(this.userRepository.existsById(id), "User not exist");
        final UserEntity userToUpdate = this.userMapper.modelToEntity(user);

        return this.userMapper.entityToModel(this.userRepository.save(userToUpdate));
    }

    public User createUser(final User user) {
        Assert.isTrue(user.getId() == null, "id must be null");
        final UserEntity userToSave = this.userMapper.modelToEntity(user);
        return this.userMapper.entityToModel(this.userRepository.save(userToSave));
    }
}
