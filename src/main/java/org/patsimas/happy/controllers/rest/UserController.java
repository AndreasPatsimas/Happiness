package org.patsimas.happy.controllers.rest;

import java.util.List;
import java.util.logging.Logger;

import org.patsimas.happy.dto.UserDto;
import org.patsimas.happy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	private static final Logger LOGGER = Logger.getLogger(UserController.class.getName());
	
	@Autowired
	UserService userService;

	@GetMapping(value = "users")
    public List<UserDto> getAllUsers(){

        LOGGER.info("Fetch all Users");

        return userService.findAll();
    }

    @GetMapping(value = "user/{userId}")
    public UserDto getUserById(@PathVariable("userId") Long userId) {

        LOGGER.info("Fetch data for user with id: " + userId);

        UserDto userDto = userService.findById(userId);

        return userDto;
    }
    
    @GetMapping(value = "image/{userId}")
    public ResponseEntity getImageByUserId(@PathVariable("userId") Long userId) {

        LOGGER.info("Fetch data for user image with id: " + userId);

        UserDto userDto = userService.findById(userId);
        
        if (userDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        LOGGER.info("Fetch image completed");
        
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, "image/*").body(userDto.getPicture());
    }
    
//    @PostMapping(value = "user")
//	public UserDto saveUser (@RequestBody UserDto userDto) {
//		
//    	userDto.UserId(0);
//		
//    	userDto.setPassword(CryptoConverter.encrypt(userDto.getPassword()));
//		
//    	userDto.addRole(Role.EMPLOYEE);
//		
//    	userService.saveOrUpdateUserDto(userDto);
//		
//		return userDto;
//	}
	
	@PutMapping(value = "user")
	public UserDto editUser (@RequestBody UserDto userDto) {
		
		//userDto.setPassword(CryptoConverter.encrypt(userDto.getPassword()));
		
		UserDto existingDataUser = userService.findById(userDto.getUserId());
		
		userDto.setPicture(existingDataUser.getPicture());
		
		userDto.setDateOfBirth(existingDataUser.getDateOfBirth());
		
		userDto.setRoles(existingDataUser.getRoles()); 
		
		userService.saveOrUpdateUserDto(userDto);
		
		return userDto;
	}
	
}
