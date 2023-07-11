package com.kzt.blog.bl.services.user.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kzt.blog.bl.services.user.UserService;
import com.kzt.blog.bl.dto.user.UserDTO;
import com.kzt.blog.persistence.entities.Role;
import com.kzt.blog.persistence.entities.User;
import com.kzt.blog.persistence.repositories.RoleRespository;
import com.kzt.blog.persistence.repositories.UserRepository;
import com.kzt.blog.web.forms.UserForm;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRespository roleRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public List<UserDTO> getAllUsers() {
		List<User> users = this.userRepository.findAll();
		List<UserDTO> userDTOList = users.stream().map(user -> {
			UserDTO userDTO = new UserDTO(user);
			return userDTO;
		}).collect(Collectors.toList());
		return userDTOList;
	}

	@Override
	public void saveUser(UserForm userForm) {
		User user = new User();
		user.setName(userForm.getName());
		user.setEmail(userForm.getEmail());
		user.setPassword(passwordEncoder.encode(userForm.getPassword()));
        user.getRoles().add(this.roleRepository.findByName("ROLE_USER"));
		this.userRepository.save(user);
	}

	@Override
	public UserDTO getUserById(Long id) {
		User user = this.userRepository.findById(id).get();
		UserDTO userDTO = new UserDTO(user);
		return userDTO;
	}
	
	@Override
	public User getUserByName(String name) {
		User user = this.userRepository.findByName(name);
		return user;
	}

	@Override
	public void updateUser(UserForm userForm) {
		User user = this.userRepository.findById(userForm.getId()).get();
		user.setName(userForm.getName());
		user.setEmail(userForm.getEmail());
		user.setPassword(passwordEncoder.encode(userForm.getPassword()));
		
		this.userRepository.save(user);
	}
	
	@Override
	public void deleteUserById(Long id) {
		User user = this.userRepository.findById(id).get();
		this.userRepository.delete(user);
	}
	
	@Override
	public List<UserDTO> search(String keyword) {
		List<User> users = this.userRepository.search(keyword);
		List<UserDTO> userDTOList = users.stream().map(user -> {
			UserDTO userDTO = new UserDTO(user);
			return userDTO;
		}).collect(Collectors.toList());
		return userDTOList;
	}
}
