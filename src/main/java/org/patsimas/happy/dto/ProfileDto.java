package org.patsimas.happy.dto;


import org.patsimas.happy.domain.Happiness;
import org.patsimas.happy.domain.Task;
import org.patsimas.happy.enums.Month;

public class ProfileDto {
	
	private Task task;
	
    private Happiness happiness;

    private Month month;

    private Integer year;

	public ProfileDto() {
		super();
	}

	public ProfileDto(Task task, Happiness happiness, Month month, Integer year) {
		super();
		this.task = task;
		this.happiness = happiness;
		this.month = month;
		this.year = year;
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
		return "ProfileDto [task=" + task + ", happiness=" + happiness + ", month=" + month + ", year=" + year + "]";
	}

}
