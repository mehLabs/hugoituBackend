/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hugoitu.backend.Service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if ("mehLabs".equals(username)) {
			return new User("mehLabs", "$2a$10$QHM9BiaNuTAbFx0bBLo73eZ23P9faIoOZSeCvZGU71cQZsl5b3LGO",
					new ArrayList<>());
		} 
                if ("argentinaprograma".equals(username)){
                        return new User("argentinaprograma", "$2a$10$QA..ixQ7VW5tYSmOAnRkCO.6fRzlqLyRhVZ7u2qUZjD0aOOdWHwSO",
					new ArrayList<>());
                }
                throw new UsernameNotFoundException("User not found with username: " + username);
	}
}