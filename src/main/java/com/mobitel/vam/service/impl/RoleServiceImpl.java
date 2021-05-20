package com.mobitel.vam.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobitel.vam.domain.Role;
import com.mobitel.vam.dto.CommonResponce;
import com.mobitel.vam.repo.RoleRepo;
import com.mobitel.vam.service.RoleService;

/**
 * @author Tharindu
 *
 * Jan 4, 2021
 */

@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	private RoleRepo roleRepo;

	@Override
	public CommonResponce<Role> createRole(Role role) {
		CommonResponce<Role> resopnce = new CommonResponce<Role>();
		try {
			role.setRoleCode(role.getRoleCode().toUpperCase());
			Role roleObj=roleRepo.save(role);
			
			resopnce.setObject(roleObj);
			resopnce.setCode(CommonResponce.successCode);
			resopnce.setMessage(CommonResponce.successMessage);
			
		} catch (Exception e) {
			resopnce.setCode(CommonResponce.errorCode);
			resopnce.setMessage(CommonResponce.errorMessage);
		}
		
		return resopnce;
	}
	
	@Override
	public CommonResponce<Role> getAllRole() {
		CommonResponce<Role> resopnce = new CommonResponce<Role>();
		try {
			
			List<Role> roleObjList=roleRepo.findAll();
			
			resopnce.setList(roleObjList);
			resopnce.setCode(CommonResponce.successCode);
			resopnce.setMessage(CommonResponce.successMessage);
			
		} catch (Exception e) {
			resopnce.setCode(CommonResponce.errorCode);
			resopnce.setMessage(CommonResponce.errorMessage);
		}
		
		return resopnce;
	}

	@Override
	public CommonResponce<Role> getRoleById(Role role) {
		CommonResponce<Role> resopnce = new CommonResponce<Role>();
		try {
			
			Optional<Role> roleObj=roleRepo.findById(role.getRoleId());
			
			resopnce.setObject(roleObj.get());
			resopnce.setCode(CommonResponce.successCode);
			resopnce.setMessage(CommonResponce.successMessage);
			
		} catch (Exception e) {
			resopnce.setCode(CommonResponce.errorCode);
			resopnce.setMessage(CommonResponce.errorMessage);
		}
		
		return resopnce;
	}

	@Override
	public CommonResponce<Role> getrolebyRoleCode(String role) {
		CommonResponce<Role> resopnce = new CommonResponce<Role>();
		try {
			
			Role roleObj=roleRepo.getrolebyRoleCode(role);
			
			resopnce.setObject(roleObj);
			resopnce.setCode(CommonResponce.successCode);
			resopnce.setMessage(CommonResponce.successMessage);
			
		} catch (Exception e) {
			resopnce.setCode(CommonResponce.errorCode);
			resopnce.setMessage(CommonResponce.errorMessage);
		}
		
		return resopnce;
	}

	@Override
	public CommonResponce<Role> deleteRole(Role role) {
		CommonResponce<Role> resopnce = new CommonResponce<Role>();
		try {
			
			Optional<Role> roleObj=roleRepo.findById(role.getRoleId());
			roleRepo.delete(roleObj.get());
			
			resopnce.setCode(CommonResponce.successCode);
			resopnce.setMessage(CommonResponce.successMessage);
			
		} catch (Exception e) {
			resopnce.setCode(CommonResponce.errorCode);
			resopnce.setMessage(CommonResponce.errorMessage);
		}
		
		return resopnce;
	}

}
