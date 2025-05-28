package com.openclassrooms.service;

import com.openclassrooms.dto.CreateMessageDTO;
import com.openclassrooms.dto.MessageDTO;
import com.openclassrooms.mapper.MessageMapper;
import com.openclassrooms.model.Message;
import com.openclassrooms.repository.MessageRepository;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public MessageDTO createMessage(CreateMessageDTO dto) {
        Message message = MessageMapper.fromCreateDTO(dto);
        Message savedMessage = messageRepository.save(message);
        MessageDTO messageDTO = new MessageDTO(
            savedMessage.getId(),
            savedMessage.getRentalId(),
            savedMessage.getUserId(),
            savedMessage.getMessage(),
            savedMessage.getCreatedAt().toString()
        );
        return messageDTO;
    }

}
