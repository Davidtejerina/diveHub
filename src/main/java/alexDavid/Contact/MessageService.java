package alexDavid.Contact;

public interface MessageService {
    java.util.List<Message> findByUser(String email);
    Message addMessage(Message message);
    void deleteMessage(Message message);
    void deleteAllMessages(String email);
}
