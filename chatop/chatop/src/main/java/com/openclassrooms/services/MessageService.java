package com.openclassrooms.chatop.service;

import com.openclassrooms.chatop.dto.CreateMessageDTO;
import com.openclassrooms.chatop.dto.MessageResponseDTO;
import com.openclassrooms.chatop.mapper.MessageMapper;
import com.openclassrooms.chatop.model.Message;
import com.openclassrooms.chatop.repository.MessageRepository;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public MessageResponseDTO createMessage(CreateMessageDTO dto) {
        Message message = MessageMapper.fromCreateDTO(dto);
        messageRepository.save(message);
        return new MessageResponseDTO("Message sent with success");
    }
}
