package com.openclassrooms.service;

import com.openclassrooms.dto.RentalRequestDto;
import com.openclassrooms.dto.RentalResponseDto;

public interface RentalService {
    RentalResponseDto createRental(RentalRequestDto rentalDto);
}
