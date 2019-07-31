package org.patsimas.happy.controllers.rest;

import java.util.List;
import java.util.logging.Logger;

import org.patsimas.happy.dto.UserDto;
import org.patsimas.happy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
}
