package org.patsimas.happy.dto;

public class TaskDto {

	private Long taskId;
	

    private String taskName;
	

    private byte [] picture;

	public TaskDto() {
		super();
	}

	public TaskDto(Long taskId, String taskName, byte[] picture) {
		super();
		this.taskId = taskId;
		this.taskName = taskName;
		this.picture = picture;
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

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	@Override
	public String toString() {
		return "TaskDto [taskId=" + taskId + ", taskName=" + taskName + "]";
	}

}
