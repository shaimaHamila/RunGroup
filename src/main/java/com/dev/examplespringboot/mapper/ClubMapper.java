package com.dev.examplespringboot.mapper;

import com.dev.examplespringboot.dto.ClubDto;
import com.dev.examplespringboot.models.Club;

import java.util.stream.Collectors;

import static com.dev.examplespringboot.mapper.EventMapper.mapToEventDto;

public class ClubMapper {
    public ClubMapper(){}
    public static Club mapToClub(ClubDto club){
        Club newClub = Club.builder()
                .id(club.getId())
                .title(club.getTitle())
                .photoURL(club.getPhotoURL())
                .content(club.getContent())
                .createdOn(club.getCreatedOn())
                .updatedOn(club.getUpdatedOn())
                .build();
        return newClub;
    }
    public static ClubDto mapToClubDto(Club club){
        ClubDto clubDto = ClubDto.builder()
                .id(club.getId())
                .title(club.getTitle())
                .photoURL(club.getPhotoURL())
                .content(club.getContent())
                .createdOn(club.getCreatedOn())
                .updatedOn(club.getUpdatedOn())
                .events(club.getEvents().stream().map(event -> mapToEventDto(event)).collect(Collectors.toList()))
                .build();
        return clubDto;
    }
}
