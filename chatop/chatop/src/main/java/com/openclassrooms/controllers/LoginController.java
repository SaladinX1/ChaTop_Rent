// package com.openclassrooms.controllers;

// import com.openclassrooms.dto.LoginResponse;
// import com.openclassrooms.services.JWTService;
// import io.swagger.v3.oas.annotations.Operation;
// import io.swagger.v3.oas.annotations.media.Content;
// import io.swagger.v3.oas.annotations.media.Schema;
// import io.swagger.v3.oas.annotations.responses.ApiResponse;
// import io.swagger.v3.oas.annotations.tags.Tag;
// import org.springframework.security.core.Authentication;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/api/auth")
// @Tag(name = "Authentication", description = "Authentication API")
// public class LoginController {

//     private final JWTService jwtService;

//     public LoginController(JWTService jwtService) {
//         this.jwtService = jwtService;
//     }

//     @PostMapping("/login")
//     @Operation(
//         summary = "Authenticate user and return JWT token",
//         responses = {
//             @ApiResponse(responseCode = "200", description = "Token generated successfully",
//                 content = @Content(schema = @Schema(implementation = LoginResponse.class))),
//             @ApiResponse(responseCode = "401", description = "Invalid credentials", content = @Content),
//             @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
//         }
//     )
//     public LoginResponse getToken(Authentication authentication) {
//         String token = jwtService.generateToken(authentication);
//         return new LoginResponse("Connexion réussie", token);
//     }

// }
