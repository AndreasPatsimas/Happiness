package org.patsimas.happy.controllers.rest;

import java.util.List;
import java.util.logging.Logger;

import org.patsimas.happy.dto.ProfileDto;
import org.patsimas.happy.services.ProfileService;
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
	
    @GetMapping(value = "currentProfile/{userId}")
    public List<ProfileDto> getCurrentProfileByUserId(@PathVariable("userId") Long userId) {

        LOGGER.info("Fetch data for profile with id: " + userId);
    	
        return profileService.findCurrentYearProfileByUserId(userId);
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
    
    @DeleteMapping(value = "deleteProfilesBeforeTwoYears")
    public void deleteUserById() {

        LOGGER.info("Begin deleting profiles");

        profileService.deleteProfilesBeforeTwoYears();

    }
}
