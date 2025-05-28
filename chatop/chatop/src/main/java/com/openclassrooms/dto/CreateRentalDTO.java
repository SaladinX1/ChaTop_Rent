package com.openclassrooms.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO pour la création d'une nouvelle location")
public class CreateRentalDTO {

    @Schema(description = "Nom ou titre de la location", example = "Appartement spacieux au centre-ville", required = true)
    private String name;

    @Schema(description = "Surface du logement en mètres carrés", example = "75", required = true)
    private Integer surface;

    @Schema(description = "Prix mensuel de la location en euros", example = "1200", required = true)
    private Integer price;

    @Schema(description = "URL de l'image représentant le logement", example = "https://exemple.com/images/location1.jpg", required = true)
    private String picture;

    @Schema(description = "Description détaillée du logement", example = "Un appartement spacieux et lumineux, idéal pour une famille.", required = true)
    private String description;

    @Schema(description = "Identifiant du propriétaire de la location", example = "4", required = true)
    private Long ownerId;

    public CreateRentalDTO() {}

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getSurface() { return surface; }
    public void setSurface(Integer surface) { this.surface = surface; }

    public Integer getPrice() { return price; }
    public void setPrice(Integer price) { this.price = price; }

    public String getPicture() { return picture; }
    public void setPicture(String picture) { this.picture = picture; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Long getOwnerId() { return ownerId; }
    public void setOwnerId(Long ownerId) { this.ownerId = ownerId; }
}
