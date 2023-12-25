package chat.app.entity;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;

@Entity
public class Message {

    public Message(Long id, String content, String owner) {
        this.id = id;
        this.content = content;
        this.owner = owner;
    }

    private Long id;
    private String content;
    private String owner;


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
