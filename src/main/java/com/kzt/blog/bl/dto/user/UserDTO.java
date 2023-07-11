package com.kzt.blog.bl.dto.user;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.kzt.blog.persistence.entities.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDTO implements UserDetails {
	private static final long serialVersionUID = 1L;

	private Long id;
    private String name;
    private String email;
    private String password; 
    private List<GrantedAuthority> roles;
    
    public UserDTO() {
    	super();
    }
    
    public UserDTO(User user) {
    	this.id = user.getId();
    	this.name = user.getName();
    	this.email = user.getEmail();
    	this.password = user.getPassword();
    	this.roles = user.getRoles().stream().map(role -> {
    		return new SimpleGrantedAuthority(role.getName());
    	}).collect(Collectors.toList());
    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		 return roles;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
}
