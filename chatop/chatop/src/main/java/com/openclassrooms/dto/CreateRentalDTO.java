public class CreateRentalDTO {

    private String name;
    private Integer surface;
    private Integer price;
    private String picture;
    private String description;
    private Long ownerId;

    public CreateRentalDTO() {}

    // Getters & Setters
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
