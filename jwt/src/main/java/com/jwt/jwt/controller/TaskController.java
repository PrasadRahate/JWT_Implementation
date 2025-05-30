package com.jwt.jwt.controller;

import com.jwt.jwt.Task.Task;
import com.jwt.jwt.Task.TaskDto;
import com.jwt.jwt.TaskServices.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService ;

    @PostMapping("/create")
    public ResponseEntity<Task> createTask (@RequestBody TaskDto dto, Principal principal){
        Task createdTask = taskService.createTask(dto, principal.getName());
        return ResponseEntity.ok(createdTask);
    }
}
