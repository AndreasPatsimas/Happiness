package org.patsimas.happy.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.patsimas.happy.enums.Month;

@Entity
@Table(name = "profiles")
public class Profile {
	
	@Id
    @Column(name = "id")
    private Long profileId;
	
	@NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
	
	@NotNull
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_id")
    private Task task;
	
	@NotNull
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "happiness_id")
    private Happiness happiness;
	
	@Column(name = "month")
    private Month month;
	
	@NotNull
	@Column(name = "year")
    private Integer year;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public Happiness getHappiness() {
		return happiness;
	}

	public void setHappiness(Happiness happiness) {
		this.happiness = happiness;
	}

	public Month getMonth() {
		return month;
	}

	public void setMonth(Month month) {
		this.month = month;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Profile [user=" + user + ", task=" + task + ", happiness=" + happiness + ", month=" + month + ", year="
				+ year + "]";
	}
	
	

}
