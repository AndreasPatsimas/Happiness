package org.patsimas.happy.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tasks")
public class Task {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long taskId;
	
	@NotNull
    @Column(name = "task_name")
    private String taskName;
	
	@NotNull
	@ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

	public Task() {
		super();
	}

	public Task(Long taskId, @NotNull String taskName, @NotNull User user) {
		super();
		this.taskId = taskId;
		this.taskName = taskName;
		this.user = user;
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
		return "Task [taskId=" + taskId + ", taskName=" + taskName + ", user=" + user + "]";
	}
	
}
