package org.patsimas.happy.convert.activity;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.patsimas.happy.domain.Activity;
import org.patsimas.happy.dto.ActivityDto;

@Component
public class ActivityToActivityDtoConverter implements Converter<Activity ,ActivityDto > {

	@Override
	public ActivityDto convert(Activity activity) {
		
		ActivityDto activityDto = new ActivityDto(activity.getActivityId(), activity.getActivityName(), 
										activity.getPicture(), activity.getAdded());
		
		return activityDto;
	}

}
