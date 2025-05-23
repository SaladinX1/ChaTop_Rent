package com.openclassrooms.service.impl;

import com.openclassrooms.dto.CreateRentalDTO;
import com.openclassrooms.dto.RentalDTO;
import com.openclassrooms.mapper.RentalMapper;
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
    public RentalDTO createRental(CreateRentalDTO dto) {
        Rental rental = RentalMapper.fromCreateDTO(dto);
        rental.setCreatedAt(LocalDateTime.now());
        rental.setUpdatedAt(LocalDateTime.now());

        Rental saved = rentalRepository.save(rental);

        return RentalMapper.toDTO(saved);
    }
}
