package org.patsimas.happy.repositories;

import org.patsimas.happy.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
