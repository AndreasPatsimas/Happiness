package org.patsimas.happy.repositories;

import java.util.List;

import org.patsimas.happy.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
	
	List<Task> findByTaskNameStartsWithIgnoreCase(String taskName);

}
