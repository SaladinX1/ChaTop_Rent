package com.openclassrooms.service;

import com.openclassrooms.dto.CreateRentalDTO;
import com.openclassrooms.dto.RentalDTO;

public interface RentalService {
    RentalDTO createRental(CreateRentalDTO rentalDto);
}