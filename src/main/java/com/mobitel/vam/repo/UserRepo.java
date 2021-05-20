package com.mobitel.vam.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mobitel.vam.domain.User;

/**
 * @author Tharindu
 *
 * Dec 30, 2020
 */
@Repository
public interface UserRepo extends JpaRepository<User, Long>{
	
	Optional<User> findByUserName(String userName);
	
	@Query("FROM User WHERE userName = :userName")
	User getByUserName(String userName);
	
	/*
	 * @Query("SELECT vam_user_seq.Nextval from dual") Long getNextVal();
	 */

}
