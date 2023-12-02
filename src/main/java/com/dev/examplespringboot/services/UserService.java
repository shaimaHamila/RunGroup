package com.dev.examplespringboot.services;

import com.dev.examplespringboot.dto.RegistrationDto;
import com.dev.examplespringboot.models.UserEntity;

public interface UserService {
    void saveUser(RegistrationDto registrationDto);

    UserEntity findByEmail(String email);

    UserEntity findByUsername(String username);
}
