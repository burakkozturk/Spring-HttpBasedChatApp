package chat.app.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

@Entity
@Table(name = "message")
public class Message {


    // Diğer constructor
    public Message(String content, String owner, Conversation conversation) {
        this.content = content;
        this.owner = owner;
        this.conversation = conversation;
    }


    // Boş constructor eklenmeli
    public Message() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private String owner;


    @ManyToOne
    private Conversation conversation;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
