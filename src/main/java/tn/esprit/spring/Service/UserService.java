package tn.esprit.spring.Service;

import java.util.List;

import tn.esprit.spring.Entity.User;

public interface UserService {
	User saveUser(User u);
	User updateUser(User u);
	void deleteUser(User u);
	 void deleteUserById(Long id);
	User getUser(Long id);
	List<User> getAllUsers();
}
