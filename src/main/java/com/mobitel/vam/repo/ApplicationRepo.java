package com.mobitel.vam.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mobitel.vam.domain.Application;

/**
 * @author Tharindu
 *
 * Jan 13, 2021
 */
@Repository
public interface ApplicationRepo extends JpaRepository<Application, Long>{

	@Query("FROM Application WHERE applicationCode=:applicationCode")
	Application getApplicationbyApplicationCode(String applicationCode);

	@Query("FROM Application ORDER BY sequence")
	List<Application> getAllApplications();
	
	@Query("FROM Application WHERE applicationId IN (:appIdList) ORDER BY sequence")
	List<Application> getApplicationsByApplicationIdList(@Param("appIdList") List<Long> appIdList);

}
