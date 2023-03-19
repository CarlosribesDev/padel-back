package com.bunker.padel.persistence.repository;

import com.bunker.padel.persistence.entity.UserEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UserRepositoryTests {

    @Autowired
    private UserRepository underTest;

    @AfterEach
    void setUp() {
        underTest.deleteAll();
    }

    @Test
    void itShouldCheckIfUserNameExist() {
        //given
        UserEntity userEntity = new UserEntity();
        userEntity.setName("Pota");

        //when
        this.underTest.save(userEntity);

        //then
        boolean result = this.underTest.existsByName("Pota");
        assertThat(result).isTrue();

    }

    @Test
    void itShouldCheckIfUserNameDoeNotExist() {
        //given
        final String name = "Pota";
//        UserEntity userEntity = new UserEntity();
//        userEntity.setName("Pota");

        //when
        boolean result = this.underTest.existsByName(name);

        //then

        assertThat(result).isFalse();

    }

}
