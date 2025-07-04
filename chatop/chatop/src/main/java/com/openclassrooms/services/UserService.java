package com.openclassrooms.service;

import com.openclassrooms.dto.*;
import com.openclassrooms.mapper.AuthMapper;
import com.openclassrooms.model.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.openclassrooms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import java.util.Collections;

import com.openclassrooms.services.JWTService;

import java.util.Optional;

// @Service
// public class UserService {

//     @Autowired
//     private UserRepository userRepository;

//     @Autowired
//     private BCryptPasswordEncoder passwordEncoder;

//     // Inscription
//     public RegisterResponse registerUser(RegisterRequest dto) {
//         // Vérifier si l'email existe déjà
//         User existingUser = userRepository.findByEmail(dto.getEmail());

//         if (existingUser != null) {
//             throw new RuntimeException("Email already registered");
//         }

//         // Mappe DTO vers User
//         User newUser = AuthMapper.toUser(dto);

//         // Encode le mot de passe
//         newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));

//         // Sauvegarde en base
//         User savedUser = userRepository.save(newUser);

//         // Mappe vers réponse
//         return AuthMapper.toRegisterResponse(savedUser, "User registered successfully");
//     }

//     // Connexion
//     public LoginResponse loginUser(LoginRequest dto) {
//        User user = userRepository.findByEmail(email)
//         .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));

//         if (user == null || !passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
//             throw new RuntimeException("Invalid credentials");
//         }

//         // Générer un token JWT (simplifié ici)
//         String token = generateFakeToken(user);

//         return AuthMapper.toLoginResponse("Login successful", token);
//     }

//     // Récupérer user par ID
//     public UserResponseDTO getUserById(Long id) {
//         Optional<User> optionalUser = userRepository.findById(id);
//         if (optionalUser.isPresent()) {
//             User user = optionalUser.get();
//             return new UserResponseDTO(user.getId(), user.getEmail(), user.getName());
//         } else {
//             throw new RuntimeException("User not found with ID: " + id);
//         }
//     }

//     public UserResponseDTO getUserByEmail(String email) {
//     User user = userRepository.findByEmail(email)
//         .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
//     return new UserResponseDTO(user.getId(), user.getName(), user.getEmail());
//     }

//     // Méthode fictive pour token (à remplacer par vraie génération JWT)
//     private String generateFakeToken(User user) {
//         return "token-for-user-" + user.getId();
//     }
// }


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

      @Autowired
    private JWTService jwtService; //

    // Inscription
    public RegisterResponse registerUser(RegisterRequest dto) {
        // Vérifier si l'email existe déjà
        if (userRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new RuntimeException("Email already registered");
        }

        // Mappe DTO vers User
        User newUser = AuthMapper.toUser(dto);

        // Encode le mot de passe
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));

        // Sauvegarde en base
        User savedUser = userRepository.save(newUser);

        // Mappe vers réponse
        return AuthMapper.toRegisterResponse(savedUser, "User registered successfully");
    }

    // Connexion
    public LoginResponse loginUser(LoginRequest dto) {
    User user = userRepository.findByEmail(dto.getEmail())
        .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + dto.getEmail()));

    if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
        throw new RuntimeException("Invalid credentials");
    }

    // Création d'une Authentication manuelle pour générer le token
    Authentication authentication = new UsernamePasswordAuthenticationToken(
    user.getEmail(),
    null,
    Collections.emptyList() // ou roles si disponibles
);

   // Authentication authentication = new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword());
    String token = jwtService.generateToken(authentication);

   // return AuthMapper.toLoginResponse("Login successful", token);
    return AuthMapper.toLoginResponse("Connexion réussie", token, user.getId());

}


    // Récupérer user par ID
    public UserResponseDTO getUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            return new UserResponseDTO(user.getId(), user.getEmail(), user.getName());
        } else {
            throw new RuntimeException("User not found with ID: " + id);
        }
    }

    // Récupérer user par email
    public UserResponseDTO getUserByEmail(String email) {
        User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
        return new UserResponseDTO(user.getId(), user.getEmail(), user.getName());
    }

    // Méthode fictive pour token (à remplacer par vraie génération JWT)
    private String generateFakeToken(User user) {
        return "token-for-user-" + user.getId();
    }
}
