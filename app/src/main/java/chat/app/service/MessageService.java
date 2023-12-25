package chat.app.service;

import chat.app.entity.Conversation;
import chat.app.entity.Message;
import chat.app.repo.ConversationRepository;
import chat.app.repo.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private final MessageRepository messageRepository;
    private final ConversationRepository conversationRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository, ConversationRepository conversationRepository) {
        this.messageRepository = messageRepository;
        this.conversationRepository = conversationRepository;
    }

    public Message sendMessage(String content, String owner, Long conversationId) {
        // Conversation kontrolü yapılabilir
        Conversation conversation = conversationRepository.findById(conversationId)
                .orElseThrow(() -> new RuntimeException("Belirtilen Conversation bulunamadı."));

        Message message = new Message(content, owner, conversation);
        return messageRepository.save(message);
    }
}
