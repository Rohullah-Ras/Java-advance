package nl.sibrenrocva.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "todo")
public class Todo {
  

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private boolean isDone;
    private LocalDateTime dateTime;
    private Long userId;

   

    public Todo() {

    }

    public Todo(String name, boolean isDone, LocalDateTime dateTime, Long userId) {
        this.name = name;
        this.isDone = isDone;
        this.dateTime = dateTime;
        this.userId = userId;
    }

    public void setIsDone(boolean b) {
        
        throw new UnsupportedOperationException("Unimplemented method 'setIsDone'");
    }
    
    public boolean isDone() {
        return isDone;
    }

    public void setName(String name2) {
        
        throw new UnsupportedOperationException("Unimplemented method 'setName'");
    }

    public void setDateTime(LocalDateTime now) {
        
        throw new UnsupportedOperationException("Unimplemented method 'setDateTime'");
    }

    public void setUser(User user) {
        
        throw new UnsupportedOperationException("Unimplemented method 'setUser'");
    }

    // Getters and setters
}
