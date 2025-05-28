package com.openclassrooms.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO for creating a new message related to a rental")
public class CreateMessageDTO {

    @Schema(description = "ID de la location concerné par le message", example = "1", required = true)
    private Long rentalId;

    @Schema(description = "ID du user envoyant le message", example = "5", required = true)
    private Long userId;

    @Schema(description = "Contenu du message", example = "je suis intéressé ! Est-ce encore disponible ?", required = true)
    private String message;

    public CreateMessageDTO() {}

    public Long getRentalId() { return rentalId; }
    public void setRentalId(Long rentalId) { this.rentalId = rentalId; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
