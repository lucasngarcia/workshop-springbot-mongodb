package com.lucasgarcia.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasgarcia.workshopmongo.domain.User;
import com.lucasgarcia.workshopmongo.repository.UserRepository;
import com.lucasgarcia.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = repo.findById(id);
		if (user.isEmpty()) throw new ObjectNotFoundException("Objeto não encontrado");
		return user.get();
	}
}
