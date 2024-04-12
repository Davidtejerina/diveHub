package alexDavid.Contact;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService{
    private final MessageRepository messageRepository;
    @Override
    public List<Message> findByUser(String email) {
        return messageRepository.findAllByEmail(email);
    }

    @Override
    public Message addMessage(Message message) {
        return messageRepository.save(message);
    }
}
