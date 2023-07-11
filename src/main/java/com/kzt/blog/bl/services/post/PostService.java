package com.kzt.blog.bl.services.post;

import java.util.List;

import com.kzt.blog.bl.dto.post.PostDTO;
import com.kzt.blog.web.forms.PostForm;

public interface PostService {
	List<PostDTO> getAllPosts();
	
	void savePost(PostForm postForm);
	
	PostDTO getPostById(Long id);
	
	void updatePost(PostForm postForm);
	
	void deletePostById(Long id);
}
