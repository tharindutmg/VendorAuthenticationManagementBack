package com.mobitel.vam.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobitel.vam.domain.Application;
import com.mobitel.vam.dto.CommonResponce;
import com.mobitel.vam.repo.ApplicationRepo;
import com.mobitel.vam.service.ApplicationService;

/**
 * @author Tharindu
 *
 * Jan 13, 2021
 */
@Service
public class ApplicationServiceImpl implements ApplicationService{
	
	@Autowired
	private ApplicationRepo applicationRepo;
	
	@Override
	public CommonResponce<Application> createApplication(Application application) {
		CommonResponce<Application> resopnce = new CommonResponce<Application>();
		try {
			application.setApplicationCode(application.getApplicationCode().toUpperCase());
			Application obj=applicationRepo.save(application);
			
			resopnce.setObject(obj);
			resopnce.setCode(CommonResponce.successCode);
			resopnce.setMessage(CommonResponce.successMessage);
			
		} catch (Exception e) {
			resopnce.setCode(CommonResponce.errorCode);
			resopnce.setMessage(CommonResponce.errorMessage);
		}
		
		return resopnce;
	}

	@Override
	public CommonResponce<Application> deleteApplication(Application application) {
		CommonResponce<Application> resopnce = new CommonResponce<Application>();
		try {
			
			Optional<Application> obj=applicationRepo.findById(application.getApplicationId());
			applicationRepo.delete(obj.get());
			
			resopnce.setCode(CommonResponce.successCode);
			resopnce.setMessage(CommonResponce.successMessage);
			
		} catch (Exception e) {
			resopnce.setCode(CommonResponce.errorCode);
			resopnce.setMessage(CommonResponce.errorMessage);
		}
		
		return resopnce;
	}

	@Override
	public CommonResponce<Application> getApplicationById(Application application) {
		CommonResponce<Application> resopnce = new CommonResponce<Application>();
		try {
			
			Optional<Application> obj=applicationRepo.findById(application.getApplicationId());
			
			resopnce.setObject(obj.get());
			resopnce.setCode(CommonResponce.successCode);
			resopnce.setMessage(CommonResponce.successMessage);
			
		} catch (Exception e) {
			resopnce.setCode(CommonResponce.errorCode);
			resopnce.setMessage(CommonResponce.errorMessage);
		}
		
		return resopnce;
	}

	@Override
	public CommonResponce<Application> getapplicationbyApplicationCode(String code) {
		CommonResponce<Application> resopnce = new CommonResponce<Application>();
		try {
			Application obj=applicationRepo.getApplicationbyApplicationCode(code.toUpperCase());
			resopnce.setObject(obj);
			resopnce.setCode(CommonResponce.successCode);
			resopnce.setMessage(CommonResponce.successMessage);
			
		} catch (Exception e) {
			resopnce.setCode(CommonResponce.errorCode);
			resopnce.setMessage(CommonResponce.errorMessage);
		}
		
		return resopnce;
	}

	@Override
	public CommonResponce<Application> getAllApplication() {
		CommonResponce<Application> resopnce = new CommonResponce<Application>();
		try {
			
			List<Application> objList=applicationRepo.getAllApplications();
			
			resopnce.setList(objList);
			resopnce.setCode(CommonResponce.successCode);
			resopnce.setMessage(CommonResponce.successMessage);
			
		} catch (Exception e) {
			resopnce.setCode(CommonResponce.errorCode);
			resopnce.setMessage(CommonResponce.errorMessage);
		}
		
		return resopnce;
	}

}
