package com.mobitel.vam.security;

import java.io.Serializable;

public class AuthenticationRequest implements Serializable {


    private String userName;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	//need default constructor for JSON Parsing
    public AuthenticationRequest()
    {

    }

    public AuthenticationRequest(String username, String password) {
        this.setUserName(username);
        this.setPassword(password);
    }
}
