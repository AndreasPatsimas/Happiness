package org.patsimas.happy.controllers.rest;

import java.util.List;
import java.util.logging.Logger;

import org.patsimas.happy.domain.User;
import org.patsimas.happy.dto.TaskDto;
import org.patsimas.happy.dto.UserDto;
import org.patsimas.happy.services.TaskService;
import org.patsimas.happy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
	
	private static final Logger LOGGER = Logger.getLogger(TaskController.class.getName());
	
	TaskService taskService;
	
	UserService userService;
	
	ConversionService conversionService;
	
	@Autowired
	public TaskController(TaskService taskService, UserService userService, ConversionService conversionService) {
		super();
		this.taskService       = taskService;
		this.userService       = userService;
		this.conversionService = conversionService;
	}

	@GetMapping(value = "tasks/{userId}")
	public List<TaskDto> getAllTasksByUserId(@PathVariable("userId") Long userId){
		
		LOGGER.info("Fetch all tasks of user with id: " + userId);
		
		return taskService.findAllByUserId(userId);
	}
	
	
	@PostMapping(value = "task/{userId}")
	public TaskDto saveTask (@RequestBody TaskDto taskDto, @PathVariable("userId") Long userId) {
		
		taskDto.setTaskId(0l);
		
		UserDto userDto = userService.findById(userId);
		
		User user = conversionService.convert(userDto, User.class);
		
		taskDto.setUser(user);
			
		taskService.saveOrUpdateTaskDto(taskDto);
		
		return taskDto;
	}
	
	@DeleteMapping(value = "deleteTask/{taskId}")
	public void deleteTaskById(@PathVariable("taskId") Long taskId) {
		
        LOGGER.info("Begin deleting task with id: " + taskId);

        taskService.deleteTaskById(taskId);
	}
	
	@DeleteMapping(value = "deleteAllUserTasks/{userId}")
	public void deleteAllTasksByUserId(@PathVariable("userId") Long userId) {
		
        LOGGER.info("Begin deleting task of user with id: " + userId);

        taskService.deleteUserAllTasksByUserId(userId);
	}

}
