package com.openclassrooms.chatop.service;

import com.openclassrooms.chatop.dto.MessageRequestDTO;
import com.openclassrooms.chatop.dto.MessageResponseDTO;
import com.openclassrooms.chatop.model.Message;
import com.openclassrooms.chatop.repository.MessageRepository;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public MessageResponseDTO createMessage(MessageRequestDTO requestDTO) {
        Message message = new Message();
        message.setRentalId(requestDTO.getRental_id());
        message.setUserId(requestDTO.getUser_id());
        message.setMessage(requestDTO.getMessage());

        messageRepository.save(message);

        return new MessageResponseDTO("Message sent with success");
    }
}
