package com.heptagon.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.heptagon.model.Author;
import com.heptagon.repository.AuthorAuthenticationRepository;

@Service
public class CustomerUserService implements UserDetailsService {
	@Autowired
	private AuthorAuthenticationRepository authorAuthenticationRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

//		Author author = authorAuthenticationRepository.findByName(username);
//		if (author != null)

		return new User(username, "", new ArrayList<>());
	}

}
