package com.jwt.jwt.TaskServices;

import com.jwt.jwt.Task.Task;
import com.jwt.jwt.Task.TaskDto;
import com.jwt.jwt.Task.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {


    @Autowired
    private TaskRepository taskrepo ;

    public Task createTask(TaskDto dto, String username){
        Task task = new Task() ;
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setCreatedby(username);
        return taskrepo.save(task);
    }
}
