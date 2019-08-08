package org.patsimas.happy.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.patsimas.happy.domain.Activity;
import org.patsimas.happy.dto.ActivityDto;
import org.patsimas.happy.repositories.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
public class ActivityServiceImpl implements ActivityService {
	
	private static final Logger LOGGER = Logger.getLogger(ActivityServiceImpl.class.getName());
	
	@Autowired
    private ConversionService conversionService;
	
	@Autowired
    private ActivityRepository activityRepository;

	@Override
	public List<ActivityDto> findAll() {
		
		LOGGER.info("Fetching data process for all activities...");
		
		List<ActivityDto> activityDtoList = new ArrayList<>();

        List<Activity> activityList = activityRepository.findAll();

        for (Activity activity : activityList) {
        	activityDtoList.add(conversionService.convert(activity, ActivityDto.class));
        }
        
        LOGGER.info("Fetching data process completed");
		
		return activityDtoList;
	}

	@Override
	public ActivityDto findById(Long activityId) {
		
		LOGGER.info("Fetching data process for activity with id: " + activityId);
		
		Optional<Activity> result = activityRepository.findById(activityId);

		Activity activity = null;

		ActivityDto activityDto = null;

        if(result.isPresent()) {
        	activity = result.get();

        	activityDto = conversionService.convert(activity, ActivityDto.class);

        	LOGGER.info("Fetching data process completed");
        }
        else {
            throw new RuntimeException("There is not a activity with id: " + activityId);
        }
		
		return activityDto;
	}

	@Override
	public List<ActivityDto> findByActivityName(String activityName) {
		
		LOGGER.info("Fetching data process for task with name: " + activityName);
		
		List<ActivityDto> activityDtoList = new ArrayList<>();

        List<Activity> activityList = activityRepository.findByActivityNameStartsWithIgnoreCase(activityName);

        for (Activity activity : activityList) {
        	activityDtoList.add(conversionService.convert(activity, ActivityDto.class));
        }
        
        LOGGER.info("Fetching data process completed");
		
		return activityDtoList;
	}

}
