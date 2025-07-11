// package com.openclassrooms.controller;

// import com.openclassrooms.dto.LoginResponse;
// import com.openclassrooms.dto.RegisterRequest;
// import com.openclassrooms.service.AuthService;
// import io.swagger.v3.oas.annotations.Operation;
// import io.swagger.v3.oas.annotations.media.Content;
// import io.swagger.v3.oas.annotations.media.Schema;
// import io.swagger.v3.oas.annotations.responses.ApiResponse;
// import io.swagger.v3.oas.annotations.tags.Tag;
// import io.swagger.v3.oas.annotations.parameters.RequestBody;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;

// @CrossOrigin(origins = "http://localhost:4200")
// @RestController
// @RequestMapping("/api/auth")
// @Tag(name = "Authentication", description = "Endpoints for user authentication")
// public class AuthController {

//     @Autowired
//     private AuthService authService;

//     @PostMapping("/login")
//     @Operation(
//         summary = "Authenticate a user and return a JWT token",
//         description = "Provide valid email and password to authenticate and receive a JWT token.",
//         requestBody = @RequestBody(
//             description = "User credentials required for login",
//             required = true,
//             content = @Content(
//                 mediaType = "application/json",
//                 schema = @Schema(implementation = RegisterRequest.class)
//             )
//         ),
//         responses = {
//             @ApiResponse(
//                 responseCode = "200",
//                 description = "Authentication successful",
//                 content = @Content(
//                     mediaType = "application/json",
//                     schema = @Schema(implementation = LoginResponse.class)
//                 )
//             ),
//             @ApiResponse(
//                 responseCode = "401",
//                 description = "Unauthorized - Invalid credentials"
//             )
//         }
//     )
//     public LoginResponse login(@RequestBody RegisterRequest request) {
//         return authService.login(request);
//     }
// }

package com.openclassrooms.controller;

import com.openclassrooms.dto.RegisterRequest;
import com.openclassrooms.dto.RegisterResponse;
import com.openclassrooms.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;
import com.openclassrooms.dto.LoginResponse;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/auth")
@Tag(name = "Authentication", description = "Endpoints for user authentication")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    @Operation(
        summary = "Authenticate a user and return a JWT token",
        description = "Provide valid email and password to authenticate and receive a JWT token.",
        requestBody = @RequestBody(
            description = "User credentials required for login",
            required = true,
            content = @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = RegisterRequest.class)
            )
        ),
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "Authentication successful",
                content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = RegisterResponse.class)
                )
            ),
            @ApiResponse(
                responseCode = "401",
                description = "Unauthorized - Invalid credentials",
                content = @Content(
                    mediaType = "application/json"
                )
            )
        }
    )
public ResponseEntity<LoginResponse> login(@RequestBody RegisterRequest request) {
    LoginResponse response = authService.login(request);
    return ResponseEntity.ok(response);
}


}

    

