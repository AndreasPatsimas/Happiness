package org.patsimas.happy.controllers.rest;

import java.util.List;
import java.util.logging.Logger;

import org.patsimas.happy.dto.ProfileDto;
import org.patsimas.happy.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {
	
	private static final Logger LOGGER = Logger.getLogger(ProfileController.class.getName());

	@Autowired
	ProfileService profileService;
	
    @GetMapping(value = "profile/{userId}")
    public List<ProfileDto> getTaskById(@PathVariable("userId") Long userId) {

        LOGGER.info("Fetch data for profile with id: " + userId);

    	List<ProfileDto> profileDto = profileService.findProfileByUserId(userId);

        return profileDto;
    }
}
