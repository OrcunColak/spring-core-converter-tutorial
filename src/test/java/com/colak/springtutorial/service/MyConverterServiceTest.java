package com.colak.springtutorial.service;

import com.colak.springtutorial.converter.UserDTO;
import com.colak.springtutorial.converter.UserEntity;
import com.colak.springtutorial.converter.UserEntity2UserDTOConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.convert.support.DefaultConversionService;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MyConverterServiceTest {
    private MyConverterService service;

    @BeforeEach
    void setup() {
        // create an instance of the DefaultConversionService and then add our converters manually for the unit test.
        DefaultConversionService conversionService = new DefaultConversionService();
        conversionService.addConverter(new UserEntity2UserDTOConverter());

        // create instance of our service and inject conversion service
        this.service = new MyConverterService(conversionService);
    }

    @Test
    void testConvert() {
        LocalDate now = LocalDate.now();
        UserEntity userEntity = new UserEntity(1L,
                "username",
                "password",
                "full name",
                now);
        var userEntities = List.of(userEntity);

        List<UserDTO> userDTOList = service.getUser(userEntities);

        // Create the expected UserDTO object to compare with the first item
        UserDTO expectedUserDTO = new UserDTO(
                "username",
                "password",
                "full name");

        assertThat(userDTOList).hasSize(1);
        // Assert the first item is equal to the expected UserDTO
        assertThat(userDTOList.getFirst()).isEqualTo(expectedUserDTO);
    }
}
