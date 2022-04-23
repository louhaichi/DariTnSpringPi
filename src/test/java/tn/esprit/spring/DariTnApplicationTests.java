package tn.esprit.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.Repository.UserRepository;
import tn.esprit.spring.Entity.User;

@SpringBootTest
class DariTnApplicationTests {

	@Autowired
	UserRepository ur;
	
	@Test
	void contextLoads() {
	}
	
	
	
}
