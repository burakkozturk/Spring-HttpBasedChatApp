package chat.app.controller;

import chat.app.entity.Message;
import chat.app.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/send")
    public ResponseEntity<Message> sendMessage(@RequestParam String content,
                                               @RequestParam String owner,
                                               @RequestParam Long conversationId) {
        Message sentMessage = messageService.sendMessage(content, owner, conversationId);
        return ResponseEntity.ok(sentMessage);
    }
}
