package org.patsimas.happy.dto;

import java.util.Date;

import org.patsimas.happy.domain.Happiness;

public class ActivityDto {

	private Long activityId;
	

    private String activityName;
    
    private Date added;
    
    private Double avgRating;
    
    private Happiness happiness;

	public ActivityDto() {
		super();
	}
	
	public ActivityDto(Long activityId, String activityName, Date added, Double avgRating, Happiness happiness) {
		super();
		this.activityId = activityId;
		this.activityName = activityName;
		this.added = added;
		this.avgRating = avgRating;
		this.happiness = happiness;
	}
	
	public Long getActivityId() {
		return activityId;
	}

	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public Date getAdded() {
		return added;
	}

	public void setAdded(Date added) {
		this.added = added;
	}

	public Double getAvgRating() {
		return avgRating;
	}


	public void setAvgRating(Double avgRating) {
		this.avgRating = avgRating;
	}

	public Happiness getHappiness() {
		return happiness;
	}

	public void setHappiness(Happiness happiness) {
		this.happiness = happiness;
	}

	@Override
	public String toString() {
		return "ActivityDto [activityId=" + activityId + ", activityName=" + activityName + ", added=" + added
				+ ", avgRating=" + avgRating + ", happiness=" + happiness + "]";
	}

}
