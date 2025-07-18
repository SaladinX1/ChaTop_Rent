package com.openclassrooms.service;

import com.openclassrooms.dto.RegisterRequest;
import com.openclassrooms.dto.RegisterResponse;
import com.openclassrooms.dto.LoginResponse;
import com.openclassrooms.model.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.openclassrooms.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Value("${jwt.key}")
    private String jwtSecret;

    public AuthService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public LoginResponse login(RegisterRequest request) {
        String email = request.getEmail();

        User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = Jwts.builder()
                .setSubject(String.valueOf(user.getId()))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 24h
                .signWith(SignatureAlgorithm.HS256, jwtSecret.getBytes())
                .compact();
   // LoginResponse response = AuthMapper.toLoginResponse("Connexion réussie", token, user.getId());
 
        return new LoginResponse("Connexion réussie", token, user.getId());
    }
}

