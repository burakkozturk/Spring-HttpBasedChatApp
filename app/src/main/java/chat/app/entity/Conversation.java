package chat.app.entity;

import jakarta.persistence.Entity;

@Entity
public class Conversation {

    public Conversation(Long id, String chatSummary) {
        this.id = id;
        this.chatSummary = chatSummary;
    }
    private Long id;
    private String chatSummary;


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
