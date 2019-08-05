package org.patsimas.happy.services;

import java.util.List;

import org.patsimas.happy.dto.UserDto;

public interface UserService {

	public List<UserDto> findAll();

    public UserDto findById(Long userId);
    
    public void saveOrUpdateUserDto(UserDto userDto);
    
}
