package com.kzt.blog.bl.services.user;

import java.util.List;

import com.kzt.blog.bl.dto.user.UserDTO;
import com.kzt.blog.persistence.entities.User;
import com.kzt.blog.web.forms.UserForm;

public interface  UserService {
	 List<UserDTO> getAllUsers();
	 
	 void saveUser(UserForm userForm);
	 
	 UserDTO getUserById(Long id);
	 
	 User getUserByName(String name);
	 
	 void updateUser(UserForm userForm);
	 
	 void deleteUserById(Long id);
	 
	 List<UserDTO> search(String keyword);
}
