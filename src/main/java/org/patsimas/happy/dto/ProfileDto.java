package org.patsimas.happy.dto;


import org.patsimas.happy.domain.Happiness;
import org.patsimas.happy.domain.Activity;
import org.patsimas.happy.enums.Month;

public class ProfileDto {
	
	private Long profileId; 
	
	private Activity activity;
	
    private Happiness happiness;

    private Month month;

    private Integer year;
    
    private Integer rating;

	public ProfileDto() {
		super();
	}


	public ProfileDto(Long profileId, Activity activity, Happiness happiness, Month month, Integer year,
			Integer rating) {
		super();
		this.profileId = profileId;
		this.activity = activity;
		this.happiness = happiness;
		this.month = month;
		this.year = year;
		this.rating = rating;
	}


	public Long getProfileId() {
		return profileId;
	}


	public void setProfileId(Long profileId) {
		this.profileId = profileId;
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

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "ProfileDto [activity=" + activity + ", happiness=" + happiness + ", month=" + month + ", year=" + year
				+ ", rating=" + rating + "]";
	}



}
