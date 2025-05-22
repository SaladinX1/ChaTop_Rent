package com.openclassrooms.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RentalResponseDto {
    private Long id;
    private String name;
    private int surface;
    private int price;
    private String picture;
    private String description;
    private Long ownerId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
