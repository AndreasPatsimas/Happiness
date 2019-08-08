package org.patsimas.happy.convert.profile;

import org.patsimas.happy.domain.Profile;
import org.patsimas.happy.dto.ProfileDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProfileToProfileDtoConverter implements Converter<Profile, ProfileDto> {

	@Override
	public ProfileDto convert(Profile profile) {

		ProfileDto profileDto = new ProfileDto(profile.getActivity(), profile.getHappiness(), profile.getMonth(), 
				profile.getYear());
		
		return profileDto;
	}

}
