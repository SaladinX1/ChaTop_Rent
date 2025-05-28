package com.openclassrooms.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Données d'un message envoyé concernant une location")
public class MessageDTO {

    @Schema(description = "Identifiant unique du message", example = "42")
    private Long id;

    @Schema(description = "Identifiant de la location concernée", example = "5")
    private Long rentalId;

    @Schema(description = "Identifiant de l'utilisateur qui a envoyé le message", example = "12")
    private Long userId;

    @Schema(description = "Contenu du message", example = "Je suis intéressé par cette location, est-elle encore disponible ?")
    private String message;

    @Schema(description = "Date de création du message (format ISO 8601)", example = "2025-05-25T14:32:00")
    private String createdAt;

    public MessageDTO() {}

    public MessageDTO(Long id, Long rentalId, Long userId, String message, String createdAt) {
    this.id = id;
    this.rentalId = rentalId;
    this.userId = userId;
    this.message = message;
    this.createdAt = createdAt;
}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getRentalId() { return rentalId; }
    public void setRentalId(Long rentalId) { this.rentalId = rentalId; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }
}
