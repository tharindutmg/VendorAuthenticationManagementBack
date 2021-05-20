package com.mobitel.vam.service;

import com.mobitel.vam.domain.Role;
import com.mobitel.vam.dto.CommonResponce;

public interface RoleService {

	CommonResponce<Role> createRole(Role role);

	CommonResponce<Role> getAllRole();

	CommonResponce<Role> getRoleById(Role role);

	CommonResponce<Role> getrolebyRoleCode(String role);

	CommonResponce<Role> deleteRole(Role role);

}
