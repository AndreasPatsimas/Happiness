package org.patsimas.happy.services;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.patsimas.happy.domain.Profile;
import org.patsimas.happy.dto.ProfileDto;
import org.patsimas.happy.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService {

	private static final Logger LOGGER = Logger.getLogger(ProfileServiceImpl.class.getName());
	
	@Autowired
    private ConversionService conversionService;
	
	@Autowired
    private ProfileRepository profileRepository;
	
	@Override
	public List<ProfileDto> findCurrentYearProfileByUserId(Long userId) {

		LOGGER.info("Fetching profile data process for user with id: " + userId);
		
        List<Profile> profileList = profileRepository.findCurrentYearProfileByUserId(userId);
        
        List<ProfileDto> profileDtoList = new ArrayList<>();

        for (Profile profile : profileList) {
        	profileDtoList.add(conversionService.convert(profile, ProfileDto.class));
        }
        
        if(!profileDtoList.isEmpty())
        	LOGGER.info("Fetching data process completed");
        
        else
        	LOGGER.info("There is not a user with id: "+userId);
		
		return profileDtoList;
	}

	@Override
	public List<ProfileDto> findPreviousYearProfileByUserId(Long userId) {
		
		LOGGER.info("Fetching profile data process for user with id: " + userId);
		
        List<Profile> profileList = profileRepository.findPreviousYearProfileByUserId(userId);
        
        List<ProfileDto> profileDtoList = new ArrayList<>();

        for (Profile profile : profileList) {
        	profileDtoList.add(conversionService.convert(profile, ProfileDto.class));
        }
        
        if(!profileDtoList.isEmpty())
        	LOGGER.info("Fetching data process completed");
        
        else
        	LOGGER.info("There is not a user with id: "+userId);
		
		return profileDtoList;
	}

	@Override
	public void deleteProfilesBeforeTwoYears() {
		
		LOGGER.info("Deleting profiles... ");
		
		profileRepository.deleteProfilesBeforeTwoYears();
		
		LOGGER.info("Deleting profiles process completed");
		
	}

	@Override
	public Double findAvgRatingPreviousYearProfileByUserId(Long userId) {
		
		LOGGER.info("Calculating average rating of previous year... ");
		
		Double avgRating = profileRepository.findAvgRatingPreviousYearProfileByUserId(userId);
		
		LOGGER.info("Calculating avg process completed");
		
		return avgRating;
	}

}
