package org.patsimas.happy.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.patsimas.happy.domain.User;
import org.patsimas.happy.dto.UserDto;
import org.patsimas.happy.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class.getName());
	
	@Autowired
    private ConversionService conversionService;
	
	@Autowired
    private UserRepository userRepository;

	@Override
	public List<UserDto> findAll() {
		
		LOGGER.info("Fetching data process for all users...");
		
		List<UserDto> userDtoList = new ArrayList<>();

        List<User> userList = userRepository.findAll();

        for (User user : userList) {
            userDtoList.add(conversionService.convert(user, UserDto.class));
        }
        
        LOGGER.info("Fetching data process completed");
		
		return userDtoList;
	}

	@Override
	public UserDto findById(Long userId) {

		LOGGER.info("Fetching data process for user with id: " + userId);
		
		Optional<User> result = userRepository.findById(userId);

		User user = null;

		UserDto userDto = null;

        if(result.isPresent()) {
        	user = result.get();

        	userDto = conversionService.convert(user,UserDto.class);

        	LOGGER.info("Fetching data process completed");
        }
        else {
            throw new RuntimeException("There is not a user with id: "+userId);
        }
		
		return userDto;
	}

	@Override
	public void saveOrUpdateUserDto(UserDto userDto) {
		
		LOGGER.info("Saving data process for user: " + userDto.getUsername());
		
		User user = conversionService.convert(userDto, User.class);
		
		userRepository.save(user);
		
		LOGGER.info("Saving data process completed");
		
	}
	

}
