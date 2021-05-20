package com.mobitel.vam.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mobitel.vam.domain.UserApp;

/**
 * @author Tharindu
 *
 * Jan 19, 2021
 */
@Repository
public interface UserAppRepo extends JpaRepository<UserApp, Long>{

	@Query("FROM UserApp WHERE userId = :usserId")
	UserApp getUserAppByUserId(Long usserId);

}
