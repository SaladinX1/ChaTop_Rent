package com.openclassrooms.service;

import com.openclassrooms.dto.UserRegisterDto;
import com.openclassrooms.model.User;
import com.openclassrooms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.openclassrooms.dto.UserResponse;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User registerUser(UserRegisterDto dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        return userRepository.save(user);
    }

    public UserResponse getUserById(Long id) {
    Optional<User> optionalUser = userRepository.findById(id);
    if (optionalUser.isPresent()) {
        User user = optionalUser.get();
        return new UserResponse(user.getId(), user.getEmail(), user.getName());
    } else {
        throw new RuntimeException("User not found with ID: " + id);
    }
}
}
