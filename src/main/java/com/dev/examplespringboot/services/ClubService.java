package com.dev.examplespringboot.services;

import com.dev.examplespringboot.dto.ClubDto;
import com.dev.examplespringboot.models.Club;

import java.util.List;

public interface ClubService {
    List<ClubDto> findAllClubs();

    Club saveClub(ClubDto clubDto);

    ClubDto findClubById(long clubId);

    void updateClub(ClubDto club);
}
