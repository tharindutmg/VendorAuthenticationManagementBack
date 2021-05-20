package com.mobitel.vam.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mobitel.vam.domain.Registration;
import com.mobitel.vam.domain.Role;

/**
 * @author Tharindu
 *
 * Dec 28, 2020
 */
@Repository
public interface RegistrationRepo extends JpaRepository<Registration, Long>{
	Registration getRegistrationByNic(String nic);
}
