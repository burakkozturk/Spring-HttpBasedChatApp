package chat.app.service;

import chat.app.entity.Conversation;
import chat.app.entity.Message;
import chat.app.repo.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConversationService {

    private final MessageRepository messageRepository;

    @Autowired
    public ConversationService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<Message> getMessageHistory(Conversation conversation) {
        return messageRepository.findByConversation(conversation);
    }
}
