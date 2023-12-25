package chat.app.repo;

import chat.app.entity.Conversation;
import chat.app.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findByConversation(Conversation conversation);
}
