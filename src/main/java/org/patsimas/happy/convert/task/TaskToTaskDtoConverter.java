package org.patsimas.happy.convert.task;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.patsimas.happy.domain.Task;
import org.patsimas.happy.dto.TaskDto;

@Component
public class TaskToTaskDtoConverter implements Converter<Task ,TaskDto > {

	@Override
	public TaskDto convert(Task task) {
		
		TaskDto taskDto = new TaskDto(task.getTaskId(), task.getTaskName(), task.getPicture());
		
		return taskDto;
	}

}
