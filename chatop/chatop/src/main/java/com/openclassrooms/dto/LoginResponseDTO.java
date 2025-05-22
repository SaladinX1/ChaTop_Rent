package com.openclassrooms.dto;

import lombok.Data;
//import lombok.Builder;


@Data
public class LoginResponseDTO {
    private String token;

    public LoginResponseDTO() {}

    public LoginResponseDTO(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}