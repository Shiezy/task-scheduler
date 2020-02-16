package com.holdings.taskscheduler.service;

import com.holdings.taskscheduler.model.Task;
import com.holdings.taskscheduler.repository.TaskRepository;
import com.holdings.taskscheduler.service.dto.TaskDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

//    @Autowired
    private ModelMapper modelMapper = new ModelMapper();

    public List<Task> getAll(){
    return taskRepository.findAll();
    }


    public Task saveTask(TaskDTO taskDTO){
        //map dto to entity and save
        return taskRepository.save(modelMapper.map(taskDTO, Task.class));
    }
}