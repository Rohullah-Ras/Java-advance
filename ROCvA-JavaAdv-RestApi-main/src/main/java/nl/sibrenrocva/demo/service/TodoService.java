package nl.sibrenrocva.demo.service;

import nl.sibrenrocva.demo.model.Todo;
import nl.sibrenrocva.demo.repository.TodoRepository;
import nl.sibrenrocva.demo.repository.UserRepository;

import org.h2.engine.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

        @Autowired
    private UserRepository userRepository;

    public Todo addTodo(Long userId, String name) {
        nl.sibrenrocva.demo.model.User user = userRepository.findById(userId).orElseThrow();
        Todo todo = new Todo();
        todo.setName(name);
        todo.setIsDone(false);
        todo.setDateTime(LocalDateTime.now());
        todo.setUser(user);
        return todoRepository.save(todo);
    }

    public List<Todo> getTodosByUser(Long userId) {
        return todoRepository.findByUserId(userId);
    }

    public Todo markAsDone(Long todoId) {
        Todo todo = todoRepository.findById(todoId).orElseThrow();
        todo.setIsDone(true);
        return todoRepository.save(todo);
    }

    public void deleteTodo(Long todoId) {
        todoRepository.deleteById(todoId);
    }
}
