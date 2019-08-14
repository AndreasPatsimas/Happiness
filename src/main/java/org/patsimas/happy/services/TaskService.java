package org.patsimas.happy.services;

import java.util.List;

import org.patsimas.happy.dto.TaskDto;

public interface TaskService {

	public List<TaskDto> findAllByUserId(Long userId);
	
	public TaskDto findById(Long taskId);
    
    public void saveOrUpdateTaskDto(TaskDto taskDto);
    
    public void deleteTaskById(Long taskId);
    
    public void deleteUserAllTasksByUserId(Long userId);
    
}
