package org.patsimas.happy.convert.task;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.patsimas.happy.domain.Activity;
import org.patsimas.happy.dto.ActivityDto;

@Component
public class ActivityDtoToActivityConverter implements Converter<ActivityDto ,Activity > {

	@Override
	public Activity convert(ActivityDto activityDto) {
		
		Activity activity = new Activity(activityDto.getActivityId(), activityDto.getActivityName(), 
								activityDto.getPicture(), activityDto.getAdded());
		
		return activity;
	}

}
