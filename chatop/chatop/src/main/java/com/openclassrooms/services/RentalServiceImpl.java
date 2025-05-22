package com.openclassrooms.service.impl;

import com.openclassrooms.dto.RentalRequestDto;
import com.openclassrooms.dto.RentalResponseDto;
import com.openclassrooms.model.Rental;
import com.openclassrooms.repository.RentalRepository;
import com.openclassrooms.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RentalServiceImpl implements RentalService {

    @Autowired
    private RentalRepository rentalRepository;

    @Override
    public RentalResponseDto createRental(RentalRequestDto dto) {
        Rental rental = Rental.builder()
            .name(dto.getName())
            .surface(dto.getSurface())
            .price(dto.getPrice())
            .picture(dto.getPicture())
            .description(dto.getDescription())
            .ownerId(dto.getOwnerId())
            .createdAt(LocalDateTime.now())
            .updatedAt(LocalDateTime.now())
            .build();

        Rental saved = rentalRepository.save(rental);

        RentalResponseDto response = new RentalResponseDto();
        response.setId(saved.getId());
        response.setName(saved.getName());
        response.setSurface(saved.getSurface());
        response.setPrice(saved.getPrice());
        response.setPicture(saved.getPicture());
        response.setDescription(saved.getDescription());
        response.setOwnerId(saved.getOwnerId());
        response.setCreatedAt(saved.getCreatedAt());
        response.setUpdatedAt(saved.getUpdatedAt());

        return response;
    }
}
