package com.colak.springconvertertutorial.converter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class UserDTO {
    String username;
    String password;
    String fullName;
}
