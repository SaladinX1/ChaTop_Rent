package com.openclassrooms.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO pour la requête de connexion d'un utilisateur")
public class LoginRequest {

    @Schema(description = "Adresse email de l'utilisateur", example = "utilisateur@example.com", required = true)
    private String email;

    @Schema(description = "Mot de passe de l'utilisateur", example = "MotDePasse123!", required = true)
    private String password;

    public LoginRequest() {}

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
