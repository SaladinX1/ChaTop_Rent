package com.openclassrooms.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Représente une location de logement")
public class RentalDTO {

    @Schema(description = "Identifiant unique de la location", example = "1")
    private Long id;

    @Schema(description = "Nom du logement", example = "Appartement cosy à Paris")
    private String name;

    @Schema(description = "Surface du logement en mètres carrés", example = "45")
    private Integer surface;

    @Schema(description = "Prix mensuel du loyer en euros", example = "1200")
    private Integer price;

    @Schema(description = "URL de l'image du logement", example = "https://example.com/image.jpg")
    private String picture;

    @Schema(description = "Description du logement", example = "Appartement lumineux et bien situé.")
    private String description;

    @Schema(description = "Identifiant de l'utilisateur propriétaire du logement", example = "3")
    private Long ownerId;

    @Schema(description = "Date de création de l'annonce (format ISO 8601)", example = "2024-05-21T10:15:30")
    private String createdAt;

    @Schema(description = "Date de dernière mise à jour de l'annonce (format ISO 8601)", example = "2024-06-01T14:20:00")
    private String updatedAt;

    public RentalDTO() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

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

    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }

    public String getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(String updatedAt) { this.updatedAt = updatedAt; }
}
