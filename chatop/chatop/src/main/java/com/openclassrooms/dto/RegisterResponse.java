package com.openclassrooms.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Réponse retournée après l'inscription d'un utilisateur", 
        example = "{\"message\": \"Inscription réussie\", \"userId\": 123}")
public class RegisterResponse {

    @Schema(description = "Message de confirmation", example = "Inscription réussie", required = true)
    private String message;

    @Schema(description = "Identifiant unique de l'utilisateur créé", example = "123", required = true)
    private Long userId;

    public RegisterResponse() {}

   public RegisterResponse(String message, Long userId) {
    this.message = message;
    this.userId = userId;
}

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
}
