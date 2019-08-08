package org.patsimas.happy.convert.task;

import org.patsimas.happy.domain.Task;
import org.patsimas.happy.dto.TaskDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TaskDtoToTaskConverter implements Converter<TaskDto, Task> {

	@Override
	public Task convert(TaskDto taskDto) {

		Task task = new Task(taskDto.getTaskId(), taskDto.getTaskName(), taskDto.getUser());
		
		return task;
	}

}
