package com.openclassrooms.service;

import com.openclassrooms.dto.*;
import com.openclassrooms.mapper.AuthMapper;
import com.openclassrooms.model.User;
import com.openclassrooms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // Inscription
    public RegisterResponse registerUser(RegisterRequest dto) {
        // Vérifier si l'email existe déjà
        if (userRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new RuntimeException("Email already registered");
        }

        // Mappe DTO vers User
        User user = AuthMapper.toUser(dto);

        // Encode le mot de passe
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Sauvegarde en base
        User savedUser = userRepository.save(user);

        // Mappe vers réponse
        return AuthMapper.toRegisterResponse(savedUser, "User registered successfully");
    }

    // Connexion
    public LoginResponse loginUser(LoginRequest dto) {
        Optional<User> optionalUser = userRepository.findByEmail(dto.getEmail());
        if (optionalUser.isEmpty()) {
            throw new RuntimeException("Invalid credentials");
        }

        User user = optionalUser.get();

        // Vérifie mot de passe
        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        // Générer un token JWT (simplifié ici)
        String token = generateFakeToken(user);

        return AuthMapper.toLoginResponse("Login successful", token);
    }

    // Récupérer user par ID
    public UserResponse getUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            return new UserResponse(user.getId(), user.getEmail(), user.getName());
        } else {
            throw new RuntimeException("User not found with ID: " + id);
        }
    }

    // Méthode fictive pour token (à remplacer par vraie génération JWT)
    private String generateFakeToken(User user) {
        return "token-for-user-" + user.getId();
    }
}
