package com.colak.springtutorial.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserEntity2UserDTOConverter2 implements Converter<UserEntity, UserDTO> {

    @Override
    public UserDTO convert(UserEntity source) {
        UserDTO userDTO = new UserDTO();

        // See https://medium.com/@mrengith/understanding-beanutils-in-spring-framework-c36520cbcae0
        // Copy using BeanUtils
        BeanUtils.copyProperties(source, userDTO);

        return userDTO;
    }
}
