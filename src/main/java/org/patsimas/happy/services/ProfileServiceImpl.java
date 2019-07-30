package org.patsimas.happy.services;

import java.util.ArrayList;
import java.util.List;

import org.patsimas.happy.domain.Profile;
import org.patsimas.happy.dto.ProfileDto;
import org.patsimas.happy.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService {

	@Autowired
    private ConversionService conversionService;
	
	@Autowired
    private ProfileRepository profileRepository;
	
	@Override
	public List<ProfileDto> findProfileByUserId(Long userId) {

        List<Profile> profileList = profileRepository.findProfileByUserId(userId);
        
        List<ProfileDto> profileDtoList = new ArrayList<>();

        for (Profile profile : profileList) {
        	profileDtoList.add(conversionService.convert(profile, ProfileDto.class));
        }
		
		return profileDtoList;
	}

}
