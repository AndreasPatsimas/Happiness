package org.patsimas.happy.convert.user;

import org.patsimas.happy.domain.User;
import org.patsimas.happy.dto.UserDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserDtoToUserConverter implements Converter<UserDto ,User > {

	@Override
	public User convert(UserDto userDto) {
		
		User user = new User(userDto.getUserId(), userDto.getUsername(), userDto.getPassword(), userDto.getEmail() ,
				userDto.getDateOfBirth(), userDto.getRegistrationDate(), userDto.getPicture(), 
				userDto.getFirstName(), userDto.getLastName(), userDto.getRoles());
		
		return user;
	}

}
