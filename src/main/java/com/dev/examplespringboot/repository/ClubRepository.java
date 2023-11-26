package com.dev.examplespringboot.repository;

import com.dev.examplespringboot.models.Club;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubRepository extends JpaRepository<Club, Long> {
}
