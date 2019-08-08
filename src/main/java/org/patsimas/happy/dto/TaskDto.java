package org.patsimas.happy.dto;

import org.patsimas.happy.domain.User;

public class TaskDto {

	private Long taskId;
	
	private String taskName;
	
	private User user;

	public TaskDto() {
		super();
	}

	public TaskDto(Long taskId, String taskName) {
		super();
		this.taskId = taskId;
		this.taskName = taskName;
	}

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "TaskDto [taskId=" + taskId + ", taskName=" + taskName + "]";
	}
	
}
