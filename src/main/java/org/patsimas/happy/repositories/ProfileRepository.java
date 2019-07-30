package org.patsimas.happy.repositories;

import java.util.List;

import org.patsimas.happy.domain.Profile;
import org.patsimas.happy.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

	List<Profile> findProfileByUserId(Long userId);
}
