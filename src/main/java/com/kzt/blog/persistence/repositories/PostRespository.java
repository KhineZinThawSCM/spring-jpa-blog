package com.kzt.blog.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kzt.blog.persistence.entities.Post;

@Repository
public interface PostRespository extends JpaRepository<Post, Long>{

}
