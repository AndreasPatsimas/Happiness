package org.patsimas.happy.controllers.rest;

import java.util.List;
import java.util.logging.Logger;

import org.patsimas.happy.dto.TaskDto;
import org.patsimas.happy.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
	
	private static final Logger LOGGER = Logger.getLogger(TaskController.class.getName());
	
	@Autowired
	TaskService taskService;
	
	@GetMapping(value = "tasks")
    public List<TaskDto> getAllTasks(){

		LOGGER.info("Fetch all tasks");

        return taskService.findAll();
    }

    @GetMapping(value = "task/{taskId}")
    public TaskDto getTaskById(@PathVariable("taskId") Long taskId) {

    	LOGGER.info("Fetch data for task with id: " + taskId);

    	TaskDto taskDto = taskService.findById(taskId);

        return taskDto;
    }
    
    @GetMapping(value = "tasks/{taskName}")
    public List<TaskDto> getTasksByName(@PathVariable("taskName") String taskName){

        LOGGER.info("Fetch tasks");

        return taskService.findByTaskName(taskName);
    }

}
