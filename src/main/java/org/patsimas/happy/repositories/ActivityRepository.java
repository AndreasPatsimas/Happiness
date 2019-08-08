package org.patsimas.happy.repositories;

import java.util.List;

import org.patsimas.happy.domain.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
	
	List<Activity> findByActivityNameStartsWithIgnoreCase(String activityName);

}
