package org.patsimas.happy.services;

import java.util.List;

import org.patsimas.happy.dto.TaskDto;

public interface TaskService {

	public List<TaskDto> findAll();

    public TaskDto findById(Long taskId);
    
    public List<TaskDto> findByTaskName(String taskName);
}
