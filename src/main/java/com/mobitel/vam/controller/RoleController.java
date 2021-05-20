package com.mobitel.vam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mobitel.vam.domain.Role;
import com.mobitel.vam.dto.CommonResponce;
import com.mobitel.vam.service.RoleService;

/**
 * @author Tharindu
 *
 * Jan 4, 2021
 */

@RestController
@CrossOrigin
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	private final String url = "admin/role";
	
	@PostMapping(url)
	public CommonResponce<Role> createRole(@RequestBody Role role) throws Exception {
		return roleService.createRole(role);
	}
	
	@PostMapping(url+"/delete")
	public CommonResponce<Role> deleteRole(@RequestBody Role role) {
	    return roleService.deleteRole(role);
	}

	
	@PostMapping(url+"/rolebyId")
	public CommonResponce<Role> getRoleById(@RequestBody Role role) throws Exception {
		return roleService.getRoleById(role);
	}
	
	@PostMapping(url+"/rolebyRoleCode")
	public CommonResponce<Role> getrolebyRoleCode(@RequestBody String role) throws Exception {
		return roleService.getrolebyRoleCode(role);
	}
	
	@GetMapping(url)
	public CommonResponce<Role> getAllRole() throws Exception {
		return roleService.getAllRole();
		
	}

}
