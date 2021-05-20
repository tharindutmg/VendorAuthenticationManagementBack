
package com.mobitel.vam.service;

import com.mobitel.vam.domain.Registration;
import com.mobitel.vam.domain.User;
import com.mobitel.vam.dto.CommonResponce;

/**
 * @author Tharindu
 *
 */
public interface RegistrationService {

	CommonResponce<Registration> createRegistration(Registration registration);

	CommonResponce<User> checkUsername(String username);

	CommonResponce<Registration> getAllUsers();

	CommonResponce<Registration> getRegistrationById(String registrationId);

}
