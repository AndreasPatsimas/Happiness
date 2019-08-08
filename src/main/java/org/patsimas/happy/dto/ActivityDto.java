package org.patsimas.happy.dto;

import java.util.Arrays;
import java.util.Date;

public class ActivityDto {

	private Long activityId;
	

    private String activityName;
	

    private byte [] picture;
    
    private Date added;

	public ActivityDto() {
		super();
	}

	public ActivityDto(Long activityId, String activityName, byte[] picture, Date added) {
		super();
		this.activityId = activityId;
		this.activityName = activityName;
		this.picture = picture;
		this.added = added;
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

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	public Date getAdded() {
		return added;
	}

	public void setAdded(Date added) {
		this.added = added;
	}

	@Override
	public String toString() {
		return "ActivityDto [activityId=" + activityId + ", activityName=" + activityName + ", picture="
				+ Arrays.toString(picture) + ", added=" + added + "]";
	}


}
