package org.patsimas.happy.domain;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "activities")
public class Activity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long activityId;
	
	@NotNull
    @Column(name = "activity_name")
    private String activityName;
	
	@Column(name = "pic")
    private byte [] picture;
	
	@Column(name = "added")
	private Date added;

	public Activity() {
		super();
	}


	public Activity(Long activityId, @NotNull String activityName, byte[] picture, Date added) {
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
		return "Activity [activityId=" + activityId + ", activityName=" + activityName + ", picture="
				+ Arrays.toString(picture) + ", added=" + added + "]";
	}

}
