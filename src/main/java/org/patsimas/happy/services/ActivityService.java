package org.patsimas.happy.services;

import java.util.List;

import org.patsimas.happy.dto.ActivityDto;

public interface ActivityService {

	public List<ActivityDto> findAll();

    public ActivityDto findById(Long activityId);
    
    public List<ActivityDto> findByActivityName(String activityName);
}
