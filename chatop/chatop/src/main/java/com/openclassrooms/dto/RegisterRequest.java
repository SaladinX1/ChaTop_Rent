package com.openclassrooms.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Données nécessaires pour l'inscription d'un nouvel utilisateur")
public class RegisterRequest {

    @Schema(description = "Adresse email de l'utilisateur", example = "jean.dupont@example.com")
    private String email;

    @Schema(description = "Mot de passe choisi par l'utilisateur", example = "MotDePasse123!")
    private String password;

    @Schema(description = "Nom de l'utilisateur", example = "Jean Dupont")
    private String name;

    public RegisterRequest() {}

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
