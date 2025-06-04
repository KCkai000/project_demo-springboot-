package com.example.demo.detail;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.model.entity.User;

public class UserDetailsImpl implements UserDetails{
	
	private final User user;
	
	public UserDetailsImpl(User user) {
		this.user = user;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority("ROLE_USER")); //尚未設置權限，先用ROLE_USER代替，未來權限這裡要改
	}
	
	@Override
	public String getUsername() {
		return user.getUserAccount();
	}
			
	@Override 
	public String getPassword() {
		return user.getPasswordHash();
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return user.getActive();
	}
	
	public Integer getUserID() {
		return user.getUserId();
	}
	
	public Integer getUserRole() {
		return user.getUserRole();
	}
}
