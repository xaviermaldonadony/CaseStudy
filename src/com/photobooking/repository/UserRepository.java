package com.photobooking.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.photobooking.model.Credential;

// @Repository inherits from @Component
@Repository

public interface UserRepository extends CrudRepository<Credential, String>{

	Credential findByUsername(String username);
	
}
