package com.openclassrooms.mapper;

import com.openclassrooms.dto.RegisterResponse;
import com.openclassrooms.dto.RegisterRequest;
import com.openclassrooms.dto.LoginRequest;
import com.openclassrooms.dto.LoginResponse;

import com.openclassrooms.model.User;



public class AuthMapper {

   


    // Mappe RegisterRequest → User 
    public static User toUser(RegisterRequest dto) {
        if (dto == null) return null;
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setName(dto.getName());
        return user;
    }

    // Mappe User → RegisterResponse
    public static RegisterResponse toRegisterResponse(User user, String message) {
        if (user == null) return null;
        return new RegisterResponse(message, user.getId());
    }

    // Mappe LoginRequest → User 
    public static User toUser(LoginRequest dto) {
        if (dto == null) return null;
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        return user;
    }

        // Mappe données pour LoginResponse 
public static LoginResponse toLoginResponse(String message, String token, Long userId) {
    return new LoginResponse(message, token, userId);
}

}
