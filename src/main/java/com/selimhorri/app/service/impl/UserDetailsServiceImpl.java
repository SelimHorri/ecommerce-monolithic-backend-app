package com.selimhorri.app.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.selimhorri.app.model.dto.UserDetailsImpl;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		return new UserDetailsImpl(null);
	}
	
	
	
}








