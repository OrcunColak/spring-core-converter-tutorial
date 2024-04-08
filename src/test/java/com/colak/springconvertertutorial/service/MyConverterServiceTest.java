package com.colak.springconvertertutorial.service;

import com.colak.springconvertertutorial.converter.UserEntity;
import com.colak.springconvertertutorial.converter.UserEntity2UserDTOConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.convert.support.DefaultConversionService;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyConverterServiceTest {
    private MyConverterService service;

    @BeforeEach
    void setup() {
        // create an instance of the DefaultConversionService and then add our converters manually for the unit test.
        var conversionService = new DefaultConversionService();
        conversionService.addConverter(new UserEntity2UserDTOConverter());

        // create instance of our service and inject conversion service
        this.service = new MyConverterService(conversionService);
    }

    @Test
    void testConvert() {
        UserEntity userEntity = new UserEntity(1L,
                "username",
                "password",
                "full name",
                LocalDate.now());
        var userEntities = List.of(userEntity);

        var result = service.getUser(userEntities);

        assertEquals(1, result.size());
    }
}
