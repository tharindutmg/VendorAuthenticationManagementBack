package com.mobitel.vam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mobitel.vam.domain.Application;
import com.mobitel.vam.dto.CommonResponce;
import com.mobitel.vam.dto.CommonURL;
import com.mobitel.vam.service.ApplicationService;

/**
 * @author Tharindu
 *
 * Jan 12, 2021
 */
@RestController
@CrossOrigin
public class ApplicationController {
	
	@Autowired
	private ApplicationService applicationService;
	
	
	
	private final String url = CommonURL.ADMIN+"/application";
	
	@PostMapping(CommonURL.application)
	public CommonResponce<Application> createApplication(@RequestBody Application application) throws Exception {
		return applicationService.createApplication(application);
	}
	
	@PostMapping(url+"/delete")
	public CommonResponce<Application> deleteApplication(@RequestBody Application application) {
	    return applicationService.deleteApplication(application);
	}

	
	@PostMapping(url+"/byId")
	public CommonResponce<Application> getApplicationById(@RequestBody Application application) throws Exception {
		return applicationService.getApplicationById(application);
	}
	
	@PostMapping(url+"/byCode")
	public CommonResponce<Application> getapplicationbyApplicationCode(@RequestBody String code) throws Exception {
		return applicationService.getapplicationbyApplicationCode(code);
	}
	
	@GetMapping(CommonURL.application)
	public CommonResponce<Application> getAllApplication() throws Exception {
		return applicationService.getAllApplication();
		
	}

}
