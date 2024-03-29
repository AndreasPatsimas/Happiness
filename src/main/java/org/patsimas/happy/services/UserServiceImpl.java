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
import org.springframework.web.multipart.MultipartFile;

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
		
		List<User> userList = userRepository.findAll();
		
		List<UserDto> userDtoList = new ArrayList<>(userList.size());

		userList.forEach(user -> userDtoList.add(conversionService.convert(user, UserDto.class)));
        
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

	@Override
	public void saveUserPhotoByUserId(Long userId, MultipartFile photo) {

		LOGGER.info("Saving photo for user with id: " + userId);
		
		try {
		
		byte[] photoBytes = photo.getBytes();
		
		if (photo.isEmpty()) {
			photoBytes = null;
		}
		
		userRepository.saveUserPhotoByUserId(userId, photoBytes);
		
		LOGGER.info("Saving photo process completed");
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteUserById(Long userId) {

		LOGGER.info("Deleting user with id: " + userId);
		
		userRepository.deleteById(userId);
		
		LOGGER.info("Deleting user process completed");
		
	}
	

}
