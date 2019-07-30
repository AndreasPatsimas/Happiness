package org.patsimas.happy.services;

import java.util.List;

import org.patsimas.happy.dto.ProfileDto;

public interface ProfileService {

	 public List<ProfileDto> findProfileByUserId(Long userId);
}
