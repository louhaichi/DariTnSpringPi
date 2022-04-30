package tn.esprit.spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.Entity.User;
import tn.esprit.spring.Repository.ImageVideoRepository;
import tn.esprit.spring.Repository.UserRepository;

import java.util.stream.Collectors;
@Service
public class UserServiceIMPL implements UserService {

	@Autowired
	UserRepository UserRepo;
	@Autowired
	ImageVideoRepository imageVideoRepository;

	@Override
	public User saveUser(User u) {

		User user = UserRepo.save(u);
		u.getImageVideo().forEach(i->i.setUser(user));
		user.setImageVideo(imageVideoRepository.saveAll(u.getImageVideo()).stream().collect(Collectors.toSet()));
		return user;
	}
		
	

	@Override
	public User updateUser(User u) {
		// TODO Auto-generated method stub
		return UserRepo.save(u);
	}

	@Override
	public void deleteUser(User u) {
		// TODO Auto-generated method stub
		UserRepo.delete(u);
	}

	@Override
	public void deleteUserById(Long id) {
		// TODO Auto-generated method stub
		UserRepo.deleteById(id);
	}

	@Override
	public User getUser(Long id) {
		// TODO Auto-generated method stub
		return UserRepo.findById(id).orElseThrow(null);
	}
	@Override
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return UserRepo.findByUsername(username).orElseThrow(null);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return UserRepo.findAll();
	}
	
	

}
