package org.patsimas.happy.domain;


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
    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    private User user;
	
	@NotNull
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "activity_id")
    private Activity activity;
	
	@NotNull
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "happiness_id")
    private Happiness happiness;
	
	@Column(name = "month")
    private Month month;
	
	@NotNull
	@Column(name = "year")
    private Integer year;
	
	@Column(name = "rating")
    private Integer rating;
	
	public Long getProfileId() {
		return profileId;
	}

	public void setProfileId(Long profileId) {
		this.profileId = profileId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Profile [user=" + user + ", activity=" + activity + ", happiness=" + happiness + ", month=" + month
				+ ", year=" + year + ", rating=" + rating + "]";
	}
	
	

}
