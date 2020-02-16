package com.holdings.taskscheduler.controllers;

import com.holdings.taskscheduler.model.Task;
import com.holdings.taskscheduler.model.enumeration.GenderEnum;
import com.holdings.taskscheduler.model.enumeration.StatusEnum;
import com.holdings.taskscheduler.service.TaskService;
import com.holdings.taskscheduler.service.dto.TaskDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/all")
    public List<Task> allAccess() {
        return taskService.getAll();
    }

    @PostMapping("/create")
    public Task createNewTask(@RequestBody TaskDTO taskDTO){
        return taskService.saveTask(taskDTO);
    }


}
