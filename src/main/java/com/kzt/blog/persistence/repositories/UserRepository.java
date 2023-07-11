package com.kzt.blog.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kzt.blog.persistence.entities.User;

@Repository("userRepository")
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

	 @Query(value = "SELECT u FROM User u WHERE u.name LIKE %:keyword% OR u.email LIKE %:keyword%")
	 public List<User> search(@Param("keyword") String keyword);
	 
	 @Query(value = "SELECT u FROM User u where u.name = :name")
	 public User findByName(@Param("name") String name);
}
