package com.anthony4834.authentication.services;

import java.util.Optional;
import java.util.Random;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.anthony4834.authentication.models.User;
import com.anthony4834.authentication.repositories.UserRepo;

@Service
public class UserServ {
	private final UserRepo repo;
	
	public UserServ(UserRepo r) {
		this.repo = r;
	}
	
	public User regUser(User user) {
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
		return repo.save(user);
	}
	public Boolean authUser(String email, String pass) {
		User user = repo.findByEmail(email);
		if(user != null) {
			return BCrypt.checkpw(pass, user.getPassword());
		}
		return false;
	}
	public User findByEmail(String email) {
		return repo.findByEmail(email);
	}
	public User findByUserId(Long id) {
		Optional<User> user = repo.findById(id);
		if(user.isPresent()) {
			return user.get();
		}
		return null;
	}
	
	//Random extra stuff
	public Boolean verifResetToken(String token, String email) {
		System.out.println(email);
		System.out.println(token);
		User user = repo.findByEmail(email);

		Boolean result = BCrypt.checkpw(token, user.getResetToken());
		
		this.genResetToken(user, 125);
		
		return result;
	}
	public User genResetToken(User u) {
		Random r = new Random();
		String chars = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
		String token = "";
		for(int i=0; i<50; i++) {
			token += chars.charAt(r.nextInt(chars.length()));
		}
		System.out.println(token);
		u.setResetToken(BCrypt.hashpw(token, BCrypt.gensalt()));
		return repo.save(u);
	}
	public User genResetToken(User u, int amount) {
		Random r = new Random();
		String chars = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
		String token = "";
		for(int i=0; i<=amount; i++) {
			token += chars.charAt(r.nextInt(chars.length()));
		}
		System.out.println(token);
		u.setResetToken(BCrypt.hashpw(token, BCrypt.gensalt()));
		return repo.save(u);
	}
}
