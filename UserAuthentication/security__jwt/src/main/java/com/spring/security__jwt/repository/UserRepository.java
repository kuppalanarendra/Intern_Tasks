package com.spring.security__jwt.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.security__jwt.entity.User;

@Repository// Indicates that this interface is a repository component in Spring(DAO)
//UserRepository interface extends jpa repository to perform crud operations work with User entity
public interface UserRepository extends JpaRepository<User, Long> {
	//abstract method to find User based on username
	 User findByUsername(String username);
}
