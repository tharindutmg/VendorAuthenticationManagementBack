package com.mobitel.vam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mobitel.vam.dto.CommonResponce;
import com.mobitel.vam.security.AuthenticationRequest;
import com.mobitel.vam.security.AuthenticationResponse;
import com.mobitel.vam.security.JwtUtil;
import com.mobitel.vam.security.MyUserDetails;
import com.mobitel.vam.service.impl.UserserviceImpl;

@RestController
@CrossOrigin
public class LoginController {
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private UserserviceImpl userDetailsService;
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public CommonResponce<AuthenticationResponse> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
		CommonResponce<AuthenticationResponse> resopnce = new CommonResponce<AuthenticationResponse>();
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(), authenticationRequest.getPassword()));
			
			final MyUserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUserName());
			final String jwt = jwtTokenUtil.generateToken(userDetails);
			
			resopnce.setCode(CommonResponce.successCode);
			resopnce.setMessage(CommonResponce.loginSuccessMessage);
			resopnce.setObject(new AuthenticationResponse(jwt,userDetails.getUserId(),userDetails.getUsername(),true,userDetails.getAuthorities()));
		}catch (BadCredentialsException e) {
			//throw new Exception("Incorrect username or password", e);
			resopnce.setCode(CommonResponce.errorCodeInvalidLogin);
			resopnce.setMessage(CommonResponce.errorMessageInvalidLogin);
		}
		
		return resopnce;
	}

}
