package com.jeancy.repository;

import com.jeancy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Jeancy
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
