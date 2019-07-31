package org.patsimas.happy.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.patsimas.happy.domain.Task;
import org.patsimas.happy.dto.TaskDto;
import org.patsimas.happy.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {
	
	@Autowired
    private ConversionService conversionService;
	
	@Autowired
    private TaskRepository taskRepository;

	@Override
	public List<TaskDto> findAll() {
		
		List<TaskDto> taskDtoList = new ArrayList<>();

        List<Task> taskList = taskRepository.findAll();

        for (Task task : taskList) {
        	taskDtoList.add(conversionService.convert(task, TaskDto.class));
        }
		
		return taskDtoList;
	}

	@Override
	public TaskDto findById(Long taskId) {
		
		Optional<Task> result = taskRepository.findById(taskId);

		Task task = null;

		TaskDto taskDto = null;

        if(result.isPresent()) {
        	task = result.get();

        	taskDto = conversionService.convert(task,TaskDto.class);

            // log.info("Fetching  data process completed");
        }
        else {
            throw new RuntimeException("There is not a task with id: "+taskId);
        }
		
		return taskDto;
	}

	@Override
	public List<TaskDto> findByTaskName(String taskName) {
		
		List<TaskDto> taskDtoList = new ArrayList<>();

        List<Task> taskList = taskRepository.findByTaskNameStartsWithIgnoreCase(taskName);

        for (Task task : taskList) {
        	taskDtoList.add(conversionService.convert(task, TaskDto.class));
        }
		
		return taskDtoList;
	}

}