package com.colak.springtutorial.service;

import com.colak.springtutorial.converter.UserDTO;
import com.colak.springtutorial.converter.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MyConverterService {

    private final ConversionService conversionService;

    public UserDTO getUser(UserEntity user) {
        // do the conversion!!
        return conversionService.convert(user, UserDTO.class);
    }

    public List<UserDTO> getUser(List<UserEntity> users) {
        return users.stream()
                .map(user -> conversionService.convert(user, UserDTO.class))
                .toList();
    }
}
