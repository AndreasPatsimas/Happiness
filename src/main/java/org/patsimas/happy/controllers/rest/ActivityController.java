package org.patsimas.happy.controllers.rest;

import java.util.List;
import java.util.logging.Logger;

import org.patsimas.happy.dto.ActivityDto;
import org.patsimas.happy.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActivityController {
	
	private static final Logger LOGGER = Logger.getLogger(ActivityController.class.getName());
	
	@Autowired
	ActivityService activityService;
	
	@GetMapping(value = "activities")
    public List<ActivityDto> getAllActivities(){

		LOGGER.info("Fetch all activities");

        return activityService.findAll();
    }

    @GetMapping(value = "activity/{activityId}")
    public ActivityDto getActivityById(@PathVariable("activityId") Long activityId) {

    	LOGGER.info("Fetch data for activity with id: " + activityId);

    	ActivityDto activityDto = activityService.findById(activityId);

        return activityDto;
    }
    
    @GetMapping(value = "activities/{activityName}")
    public List<ActivityDto> getActivitiesByName(@PathVariable("activityName") String activityName){

        LOGGER.info("Fetch activities");

        return activityService.findByActivityName(activityName);
    }

}
