package org.patsimas.happy.convert.user;

import org.patsimas.happy.domain.User;
import org.patsimas.happy.dto.UserDto;
import org.springframework.core.convert.converter.Converter;

public class UserDtoToUser implements Converter<UserDto ,User > {

	@Override
	public User convert(UserDto userDto) {
		
		User user = new User(userDto.getUserId(), userDto.getUsername(), userDto.getPassword(), userDto.getEmail() ,
				userDto.getDateOfBirth(), userDto.getRegistrationDate(), userDto.getPicture(), 
				userDto.getFirstName(), userDto.getLastName());
		
		return user;
	}

}
