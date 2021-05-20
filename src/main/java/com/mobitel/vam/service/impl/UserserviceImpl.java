package com.mobitel.vam.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mobitel.vam.domain.User;
import com.mobitel.vam.repo.UserRepo;
import com.mobitel.vam.security.MyUserDetails;


@Service
public class UserserviceImpl implements UserDetailsService{
	
	@Autowired
    UserRepo userRepository;
	
	@Override
    public MyUserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //return new User("foo", "foo",new ArrayList<>());
		Optional<User> user = userRepository.findByUserName(userName);
        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));
        return user.map(MyUserDetails::new).get();
        
    }

}
