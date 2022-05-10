package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.User;

public interface UserService {
	User saveUser(User u);
	User updateUser(User u);
	void deleteUser(User u);
	 void deleteUserById(Long id);
	User getUserByUsername(String username);
	User getUser(Long id);
	void SetImageUser(Long id,String img);
	
	List<User> getAllUsers();
}
