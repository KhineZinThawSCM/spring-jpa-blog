package com.kzt.blog.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kzt.blog.persistence.entities.Role;

@Repository("roleRespository")
public interface RoleRespository extends JpaRepository<Role, Long> {
	 @Query(value = "SELECT r FROM Role r where r.name = :name")
	 public Role findByName(@Param("name") String name);
}
