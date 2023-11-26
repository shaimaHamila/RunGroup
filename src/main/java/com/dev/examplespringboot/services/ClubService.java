package com.dev.examplespringboot.services;

import com.dev.examplespringboot.dto.ClubDto;

import java.util.List;

public interface ClubService {
    List<ClubDto> findAllClubs();
}
