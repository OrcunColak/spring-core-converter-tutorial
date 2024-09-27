package com.colak.springtutorial.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserEntity2UserDTOConverter implements Converter<UserEntity, UserDTO> {

    @Override
    public UserDTO convert(UserEntity source) {
        return UserDTO.builder()
                .username(source.getUsername())
                .password(source.getPassword())
                .fullName(source.getFullName())
                .build();
    }
}
