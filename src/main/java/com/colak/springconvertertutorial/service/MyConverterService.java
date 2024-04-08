package com.colak.springconvertertutorial.service;

import com.colak.springconvertertutorial.converter.UserDTO;
import com.colak.springconvertertutorial.converter.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyConverterService {

    private final ConversionService conversionService;

    @Autowired
    public MyConverterService(final ConversionService conversionService) {
        this.conversionService = conversionService;
    }

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
