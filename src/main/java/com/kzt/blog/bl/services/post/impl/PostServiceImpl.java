package com.kzt.blog.bl.services.post.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kzt.blog.bl.dto.post.PostDTO;
import com.kzt.blog.bl.services.post.PostService;
import com.kzt.blog.persistence.entities.Post;
import com.kzt.blog.persistence.entities.User;
import com.kzt.blog.persistence.repositories.PostRespository;
import com.kzt.blog.persistence.repositories.UserRepository;
import com.kzt.blog.web.forms.PostForm;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRespository postRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<PostDTO> getAllPosts() {
		List<Post> posts = this.postRepository.findAll();
		List<PostDTO> postDTOList = posts.stream().map(post -> {
			PostDTO postDTO = new PostDTO(post);
			return postDTO;
		}).collect(Collectors.toList());
		return postDTOList;
	}
	
	@Override
	public void savePost(PostForm postForm) {
		User user = this.userRepository.findById(postForm.getUserId()).get();
		Post post = new Post();
		post.setTitle(postForm.getTitle());
		post.setDescription(postForm.getDescription());
		post.setUser(user);
		
		this.postRepository.save(post);
	}
	
	@Override
	public PostDTO getPostById(Long id) {
		Post post = this.postRepository.findById(id).get();
		PostDTO postDTO = new PostDTO(post);
		return postDTO;
	}
	
	@Override
	public void updatePost(PostForm postForm) {
		Post post = this.postRepository.findById(postForm.getId()).get();
		User user = this.userRepository.findById(postForm.getUserId()).get();
		post.setTitle(postForm.getTitle());
		post.setDescription(postForm.getDescription());
		post.setUser(user);
		
		this.postRepository.save(post);
	}
	
	@Override
	public void deletePostById(Long id) {
		Post post = this.postRepository.findById(id).get();
		this.postRepository.delete(post);
	}
}
