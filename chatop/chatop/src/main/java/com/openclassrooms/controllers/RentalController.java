package com.openclassrooms.controller;

import com.openclassrooms.dto.RentalRequestDto;
import com.openclassrooms.dto.RentalResponseDto;
import com.openclassrooms.service.RentalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rentals")
@Tag(name = "Rental", description = "Rental management endpoints")
public class RentalController {

    @Autowired
    private RentalService rentalService;

    @PostMapping
    @Operation(
        summary = "Create a new rental",
        requestBody = @RequestBody(
            description = "Rental to create",
            required = true,
            content = @Content(schema = @Schema(implementation = RentalRequestDto.class))
        ),
        responses = {
            @ApiResponse(responseCode = "200", description = "Rental successfully created",
                content = @Content(schema = @Schema(implementation = RentalResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
        }
    )
    public ResponseEntity<RentalResponseDto> createRental(@RequestBody RentalRequestDto dto) {
        return ResponseEntity.ok(rentalService.createRental(dto));
    }
}