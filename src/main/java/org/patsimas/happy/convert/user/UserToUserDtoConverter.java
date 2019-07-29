package org.patsimas.happy.convert.user;

import org.patsimas.happy.domain.User;
import org.patsimas.happy.dto.UserDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserToUserDtoConverter implements Converter<User ,UserDto > {

	@Override
	public UserDto convert(User user) {
		
		UserDto userDto = new UserDto(user.getUserId(), user.getUsername(), user.getPassword(), user.getEmail() ,
				user.getDateOfBirth(), user.getRegistrationDate(), user.getPicture(), user.getFirstName(), 
				user.getLastName());
				
		return userDto;
	}


}
