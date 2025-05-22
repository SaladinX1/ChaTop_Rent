package com.openclassrooms.chatop.controller;

import com.openclassrooms.chatop.dto.MessageRequestDTO;
import com.openclassrooms.chatop.dto.MessageResponseDTO;
import com.openclassrooms.chatop.service.MessageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/messages")
@Tag(name = "Messages", description = "Message API")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping
    @Operation(
        summary = "Send a message",
        requestBody = @RequestBody(
            description = "Message to send",
            required = true,
            content = @Content(schema = @Schema(implementation = MessageRequestDTO.class))
        ),
        responses = {
            @ApiResponse(responseCode = "200", description = "Message sent successfully",
                content = @Content(schema = @Schema(implementation = MessageResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
        }
    )
    public ResponseEntity<MessageResponseDTO> createMessage(@RequestBody MessageRequestDTO requestDTO) {
        return ResponseEntity.ok(messageService.createMessage(requestDTO));
    }
}
