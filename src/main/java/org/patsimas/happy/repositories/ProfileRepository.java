package org.patsimas.happy.repositories;

import java.util.List;

import org.patsimas.happy.domain.Profile;
import org.patsimas.happy.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

	@Query(value = "SELECT * FROM check_happiness.profiles WHERE user_id = :userId", 
			nativeQuery = true)
	List<Profile> findProfileByUserId(Long userId);
}
