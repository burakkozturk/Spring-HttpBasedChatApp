package chat.app.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "conversation")
public class Conversation {

    public Conversation(Long id, String chatSummary) {
        this.id = id;
        this.chatSummary = chatSummary;
    }

    public Conversation() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String chatSummary;


    @OneToMany(mappedBy = "conversation")
    private List<Message> messages;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChatSummary() {
        return chatSummary;
    }

    public void setChatSummary(String chatSummary) {
        this.chatSummary = chatSummary;
    }
}
