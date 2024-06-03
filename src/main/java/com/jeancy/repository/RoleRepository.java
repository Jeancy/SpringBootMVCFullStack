package com.jeancy.repository;

import com.jeancy.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Jeancy
 */
public interface RoleRepository extends JpaRepository<Role, Long>{
    
}
