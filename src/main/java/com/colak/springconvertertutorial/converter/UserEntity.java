package com.colak.springconvertertutorial.converter;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class UserEntity {
    Long id;
    String username;
    String password;
    String fullName;
    LocalDate lastLogin;
}
