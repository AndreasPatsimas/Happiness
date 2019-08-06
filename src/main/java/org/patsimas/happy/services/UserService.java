package org.patsimas.happy.services;

import java.sql.Blob;
import java.util.List;

import org.patsimas.happy.dto.UserDto;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {

	public List<UserDto> findAll();

    public UserDto findById(Long userId);
    
    public void saveOrUpdateUserDto(UserDto userDto);
    
    public Blob getPictureByUserId(Long userId);
    
    public void saveUserPhotoByUserId(Long userId, MultipartFile photo);
    
}
