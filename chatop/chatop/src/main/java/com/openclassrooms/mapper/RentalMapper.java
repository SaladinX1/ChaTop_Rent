package com.openclassrooms.mapper;

import com.openclassrooms.dto.RentalDTO;
import com.openclassrooms.dto.CreateRentalDTO;

import com.openclassrooms.model.Rental;


import java.time.format.DateTimeFormatter;

public class RentalMapper {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static RentalDTO toDTO(Rental rental) {
        RentalDTO dto = new RentalDTO();
        dto.setId(rental.getId());
        dto.setName(rental.getName());
        dto.setSurface(rental.getSurface());
        dto.setPrice(rental.getPrice());
        dto.setPicture(rental.getPicture());
        dto.setDescription(rental.getDescription());
        dto.setOwnerId(rental.getOwnerId());
        dto.setCreatedAt(rental.getCreatedAt() != null ? rental.getCreatedAt().format(formatter) : null);
        dto.setUpdatedAt(rental.getUpdatedAt() != null ? rental.getUpdatedAt().format(formatter) : null);
        return dto;
    }

    public static Rental fromCreateDTO(CreateRentalDTO dto) {
        Rental rental = new Rental();
        rental.setName(dto.getName());
        rental.setSurface(dto.getSurface());
        rental.setPrice(dto.getPrice());
        rental.setPicture(dto.getPicture());
        rental.setDescription(dto.getDescription());
        rental.setOwnerId(dto.getOwnerId());
        
        return rental;
    }
}
