package com.dev.examplespringboot.dto;

import com.dev.examplespringboot.models.Club;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventDto {

    private long id;
    @NotEmpty(message = "Event name should not be empty!")
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime startTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime endTime;
    @NotEmpty(message = "Event type should not be empty!")
    private String type;
    @NotEmpty(message = "Event photoURL should not be empty!")
    private String photoURL;
    private LocalDateTime creationOn;
    private LocalDateTime updatedOn ;
    private Club club;
}
