package org.patsimas.happy.repositories;

import java.util.List;

import org.patsimas.happy.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface TaskRepository extends JpaRepository<Task, Long> {

	@Query(value = "SELECT * FROM check_happiness.tasks WHERE user_id = :userId", 
			nativeQuery = true)
	List<Task> findAllByUserId(@Param("userId") Long userId);
	
	
	@Transactional
    @Modifying
	@Query(value = "DELETE FROM check_happiness.tasks WHERE user_id = :userId", 
			nativeQuery = true)
	void deleteUserAllTasksByUserId(@Param("userId") Long userId);
}
