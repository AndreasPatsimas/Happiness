package org.patsimas.happy.repositories;

import java.sql.Blob;

import org.patsimas.happy.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Long> {
	
	@Transactional
    @Modifying
	@Query(value = "UPDATE check_happiness.users SET pic = :photo WHERE id = :userId", 
			nativeQuery = true) 
	void saveUserPhotoByUserId(@Param("userId") Long userId, @Param("photo") byte[] photo);
}
