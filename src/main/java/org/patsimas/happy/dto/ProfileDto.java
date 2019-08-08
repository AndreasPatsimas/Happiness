package org.patsimas.happy.dto;


import org.patsimas.happy.domain.Happiness;
import org.patsimas.happy.domain.Activity;
import org.patsimas.happy.enums.Month;

public class ProfileDto {
	
	private Activity activity;
	
    private Happiness happiness;

    private Month month;

    private Integer year;

	public ProfileDto() {
		super();
	}

	public ProfileDto(Activity activity, Happiness happiness, Month month, Integer year) {
		super();
		this.activity = activity;
		this.happiness = happiness;
		this.month = month;
		this.year = year;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
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
		return "ProfileDto [activity=" + activity + ", happiness=" + happiness + ", month=" + month + ", year=" + year + "]";
	}

}
