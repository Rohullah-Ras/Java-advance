package nl.sibrenrocva.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class LogItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateTime;
    private String level;   // info, warning, error
    private String message;

    public LogItem() {
        this.dateTime = LocalDateTime.now();
    }

    public LogItem(String level, String message) {
        this.dateTime = LocalDateTime.now();
        this.level = level;
        this.message = message;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getDateTime() { return dateTime; }
    public void setDateTime(LocalDateTime dateTime) { this.dateTime = dateTime; }

    public String getLevel() { return level; }
    public void setLevel(String level) { this.level = level; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
