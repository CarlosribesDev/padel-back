package com.bunker.padel.service;

import com.bunker.padel.mapper.UserMapper;
import com.bunker.padel.model.User;
import com.bunker.padel.persistence.entity.UserEntity;
import com.bunker.padel.persistence.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private UserMapper userMapper;

    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        userService = new UserService(userRepository, userMapper);
    }

    private UserEntity getUserEntity(final Long id,final String name) {
        final UserEntity userEntity = new UserEntity();
        userEntity.setName(name);
        userEntity.setId(id);

        return userEntity;
    }

    private User getUser(final Long id,final String name) {
        final User user = new User();
        user.setName(name);
        user.setId(id);

        return user;
    }

    @Test
    public void testGetAllUsers() {
        List<UserEntity> userEntities = new ArrayList<>();

        userEntities.add(this.getUserEntity(1L, "John"));
        userEntities.add(this.getUserEntity(2L, "Jane"));

        List<User> users = new ArrayList<>();
        users.add(this.getUser(1L, "John"));
        users.add(this.getUser(2L, "Jane"));

        when(userRepository.findAll()).thenReturn(userEntities);
        when(userMapper.entitiesToModels(userEntities)).thenReturn(users);

        List<User> result = userService.getAllUsers();

        verify(userRepository).findAll();
        verify(userMapper).entitiesToModels(userEntities);

        assertEquals(users, result);
    }

    @Test
    public void testCreateUser() {
        User user = this.getUser(null, "John");
        UserEntity userEntity = this.getUserEntity(null, "John");
        when(userMapper.modelToEntity(user)).thenReturn(userEntity);
        when(userRepository.save(userEntity)).thenReturn(this.getUserEntity(1L, "John"));
        when(userMapper.entityToModel(this.getUserEntity(1L, "John"))).thenReturn(this.getUser(1L, "John"));

        User result = userService.createUser(user);

        verify(userMapper).modelToEntity(user);
        verify(userRepository).save(userEntity);
        verify(userMapper).entityToModel(this.getUserEntity(1L, "John"));

        assertEquals(this.getUser(1L, "John"), result);
    }
}