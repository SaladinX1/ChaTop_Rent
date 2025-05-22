package com.openclassrooms.chatop.dto;

import lombok.Data;
//import lombok.Builder;


@Data
public class MessageResponseDTO {
    private String message;

    public MessageResponseDTO() {}

    public MessageResponseDTO(String message) {
        this.message = message;
    }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
