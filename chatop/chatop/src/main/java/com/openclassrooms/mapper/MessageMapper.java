import java.time.format.DateTimeFormatter;

public class MessageMapper {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static MessageDTO toDTO(Message message) {
        MessageDTO dto = new MessageDTO();
        dto.setId(message.getId());
        dto.setRentalId(message.getRentalId());
        dto.setUserId(message.getUserId());
        dto.setMessage(message.getMessage());
        dto.setCreatedAt(message.getCreatedAt() != null ? message.getCreatedAt().format(formatter) : null);
        return dto;
    }

    public static Message toEntity(MessageDTO dto) {
        Message message = new Message();
        message.setId(dto.getId());
        message.setRentalId(dto.getRentalId());
        message.setUserId(dto.getUserId());
        message.setMessage(dto.getMessage());
        return message;
    }
}