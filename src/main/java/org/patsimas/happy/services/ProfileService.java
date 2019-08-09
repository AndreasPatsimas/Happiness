package org.patsimas.happy.services;

import java.util.List;

import org.patsimas.happy.dto.ProfileDto;

public interface ProfileService {

	 public List<ProfileDto> findCurrentYearProfileByUserId(Long userId);
	 
	 public List<ProfileDto> findPreviousYearProfileByUserId(Long userId);
	 
	 public void deleteProfilesBeforeTwoYears();
	 
	 public Double findAvgRatingPreviousYearProfileByUserId(Long userId);
}
