package org.patsimas.happy.repositories;

import java.util.List;

import org.patsimas.happy.domain.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

	@Query(value = "SELECT * FROM check_happiness.profiles WHERE user_id = :userId and year = YEAR(CURDATE())  order by month", 
			nativeQuery = true)
	List<Profile> findCurrentYearProfileByUserId(@Param("userId") Long userId);
	
	@Query(value = "SELECT * FROM check_happiness.profiles WHERE user_id = :userId and year = YEAR(CURDATE()) - 1 ", 
			nativeQuery = true)
	List<Profile> findPreviousYearProfileByUserId(@Param("userId") Long userId);
	
	@Query(value = "SELECT avg(rating) FROM check_happiness.profiles WHERE user_id = :userId and year = YEAR(CURDATE()) - 1 ", 
			nativeQuery = true)
	Double findAvgRatingPreviousYearProfileByUserId(@Param("userId") Long userId);
	
	@Transactional
    @Modifying
	@Query(value = "DELETE FROM check_happiness.profiles WHERE check_happiness.profiles.year < YEAR(CURDATE()) -1", 
			nativeQuery = true) 
	void deleteProfilesBeforeTwoYears();
}
