package nl.sibrenrocva.demo.controller;

import nl.sibrenrocva.demo.model.Todo;
import nl.sibrenrocva.demo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @PostMapping("")
    public Todo addTodo(@RequestParam Long userId, @RequestParam String name) {
        return todoService.addTodo(userId, name);
    }

    @GetMapping("/{userId}")
    public List<Todo> getTodos(@PathVariable Long userId) {
        return todoService.getTodosByUser(userId);
    }

    @PostMapping("/{todoId}/done")
    public Todo markAsDone(@PathVariable Long todoId) {
        return todoService.markAsDone(todoId);
    }

    @DeleteMapping("/{todoId}")
    public void deleteTodo(@PathVariable Long todoId) {
        todoService.deleteTodo(todoId);
    }
}


