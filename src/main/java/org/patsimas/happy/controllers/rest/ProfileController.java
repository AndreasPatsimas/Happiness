package org.patsimas.happy.controllers.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.patsimas.happy.domain.Happiness;
import org.patsimas.happy.dto.ActivityDto;
import org.patsimas.happy.dto.ProfileDto;
import org.patsimas.happy.services.ActivityService;
import org.patsimas.happy.services.ProfileService;
import org.patsimas.happy.utils.HappinessUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {
	
	private static final Logger LOGGER = Logger.getLogger(ProfileController.class.getName());

	@Autowired
	ProfileService profileService;
	
	@Autowired
	ActivityService activityService;
	
    @GetMapping(value = "currentProfile/{userId}")
    public List<ProfileDto> getCurrentProfileByUserId(@PathVariable("userId") Long userId) {

        LOGGER.info("Fetch data for profile with id: " + userId);
    	
        return profileService.findCurrentYearProfileByUserId(userId);
    }
    
    @GetMapping(value = "specificUserActivities/{userId}")
    public List<ActivityDto> getActivitiesOfSpecificUser(@PathVariable("userId") Long userId) {

        LOGGER.info("Fetch activities for user with id: " + userId);
    	
        List<ActivityDto> activitiesOfUserList = new ArrayList<>();
        
        for(Long id : profileService.findSpecificUserActivities(userId)) {
        	
        	ActivityDto activityDto = activityService.findById(id);
        	
        	activityDto.setAvgRating(profileService.findAvgRatingPerActivityOfCurrentYearByUserId(userId, id));
        	
        	activityDto.setHappiness(HappinessUtil.setHappinessByRating(activityDto.getAvgRating()));
        	
        	activitiesOfUserList.add(activityDto);
        }
        
        return activitiesOfUserList;
    }
    
    @GetMapping(value = "previousProfile/{userId}")
    public List<ProfileDto> getPreviousProfileByUserId(@PathVariable("userId") Long userId) {

        LOGGER.info("Fetch data for profile with id: " + userId);

        return profileService.findPreviousYearProfileByUserId(userId);
    }
    
    @GetMapping(value = "avgPreviousProfile/{userId}")
    public Double getAvgRatingPreviousYearProfileByUserId(@PathVariable("userId")Long userId) {
    	
    	LOGGER.info("Calculate average rating in previous year of user with id: " + userId);
    	
    	return profileService.findAvgRatingPreviousYearProfileByUserId(userId);
    }
    
    @GetMapping(value = "avgCurrentProfile/{userId}")
    public Double getAvgRatingCurrentYearProfileByUserId(@PathVariable("userId")Long userId) {
    	
    	LOGGER.info("Calculate average rating in current year of user with id: " + userId);
    	
    	return profileService.findAvgRatingCurrentYearProfileByUserId(userId);
    }
    
    @DeleteMapping(value = "deleteProfilesBeforeTwoYears")
    public void deleteUserById() {

        LOGGER.info("Begin deleting profiles");

        profileService.deleteProfilesBeforeTwoYears();

    }
    
    @DeleteMapping(value = "removeActivityOfUserForSpecificMonthByProfileId/{profileId}")
    public void removeActivityOfUserForSpecificMonthByProfileId(@PathVariable("profileId") Long profileId) {
    	
    	LOGGER.info("Begin deleting activity of user");
    	
    	profileService.deleteActivityOfUserForSpecificMonthByProfileId(profileId);
    }
    
}
