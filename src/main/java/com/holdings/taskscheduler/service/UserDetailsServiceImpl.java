package com.holdings.taskscheduler.service;

import com.holdings.taskscheduler.model.User;
import com.holdings.taskscheduler.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {

		Optional<User> optional = userRepository.findByPhone(phone);
		if(optional.isPresent()){
			return UserDetailsImpl.build(optional.get());

		}else {
			throw new UsernameNotFoundException("User Not Found with phone"+ phone);
		}


	}

}