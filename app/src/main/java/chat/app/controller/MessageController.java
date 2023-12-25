package chat.app.controller;

import chat.app.entity.Conversation;
import chat.app.entity.Message;
import chat.app.service.ConversationService;
import chat.app.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private final MessageService messageService;
    private final ConversationService conversationService;

    @Autowired
    public MessageController(MessageService messageService, ConversationService conversationService) {
        this.messageService = messageService;
        this.conversationService = conversationService;
    }

    @PostMapping("/send")
    public ResponseEntity<Message> sendMessage(@RequestParam String content,
                                               @RequestParam String owner,
                                               @RequestParam Long conversationId) {
        Message sentMessage = messageService.sendMessage(content, owner, conversationId);
        return ResponseEntity.ok(sentMessage);
    }


    @GetMapping("/{conversationId}")
    public ResponseEntity<List<Message>> getMessageHistory(@PathVariable Long conversationId) {
        // Burada conversationId'yi kullanarak Conversation objesini alabilirsiniz,
        // örneğin bir ConversationService kullanarak ConversationRepository üzerinden.

        // Örnek olarak Conversation nesnesini doğrudan oluşturuyoruz.
        Conversation conversation = new Conversation();
        conversation.setId(conversationId);

        List<Message> messageHistory = conversationService.getMessageHistory(conversation);
        return ResponseEntity.ok(messageHistory);
    }
}
