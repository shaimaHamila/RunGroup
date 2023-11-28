package com.dev.examplespringboot.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventDto {

    private long id;
    private String name;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String type;
    private String photoURL;
    private LocalDateTime creationOn;
    private LocalDateTime updatedOn ;
}
