package com.mobitel.vam.service;

import com.mobitel.vam.domain.Application;
import com.mobitel.vam.dto.CommonResponce;

/**
 * @author Tharindu
 *
 * Jan 13, 2021
 */
public interface ApplicationService {

	CommonResponce<Application> createApplication(Application application);

	CommonResponce<Application> deleteApplication(Application application);

	CommonResponce<Application> getApplicationById(Application application);

	CommonResponce<Application> getapplicationbyApplicationCode(String code);

	CommonResponce<Application> getAllApplication();

}
