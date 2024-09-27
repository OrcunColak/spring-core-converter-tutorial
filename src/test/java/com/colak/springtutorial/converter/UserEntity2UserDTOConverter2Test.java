package com.colak.springtutorial.converter;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserEntity2UserDTOConverter2Test {

    @Test
    void convert() {
        LocalDate now = LocalDate.now();
        UserEntity userEntity = new UserEntity(1L,
                "username",
                "password",
                "full name",
                now);

        UserEntity2UserDTOConverter2 converter = new UserEntity2UserDTOConverter2();
        UserDTO userDTO = converter.convert(userEntity);

        // Create the expected UserDTO object to compare with the first item
        UserDTO expectedUserDTO = new UserDTO(
                "username",
                "password",
                "full name");

        assertThat(userDTO).isEqualTo(expectedUserDTO);
    }
}