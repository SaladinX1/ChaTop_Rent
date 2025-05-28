package com.openclassrooms.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Réponse renvoyée après une tentative de connexion")
public class LoginResponse {

    @Schema(description = "Message de retour indiquant le succès ou l’échec de la connexion", example = "Connexion réussie")
    private String message;

    @Schema(description = "Token JWT généré à l'authentification", example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...")
    private String token;

    public LoginResponse() {}

    public LoginResponse(String message, String token) {
        this.message = message;
        this.token = token;
    }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }
}
