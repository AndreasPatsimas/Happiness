package org.patsimas.happy.services;

import java.util.List;

import org.patsimas.happy.dto.ProfileDto;

public interface ProfileService {

	 public List<ProfileDto> findCurrentYearProfileByUserId(Long userId);
	 
	 public List<ProfileDto> findPreviousYearProfileByUserId(Long userId);
	 
	 public void deleteProfilesBeforeTwoYears();
	 
	 public Double findAvgRatingPreviousYearProfileByUserId(Long userId);
	 
	 public List<Long> findSpecificUserActivities(Long userId);
	 
	 public Double findAvgRatingPerActivityOfCurrentYearByUserId(Long userId, Long activityId);
	 
	 public Double findAvgRatingCurrentYearProfileByUserId(Long userId);
	 
	 public void deleteActivityOfUserForSpecificMonthByProfileId(Long profileId);
}
