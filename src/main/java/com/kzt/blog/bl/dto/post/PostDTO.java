package com.kzt.blog.bl.dto.post;

import com.kzt.blog.persistence.entities.Post;
import com.kzt.blog.persistence.entities.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
	private Long id;
	private String title;
	private String description;
	private User user;
	
	public PostDTO(Post post) {
		this.id = post.getId();
		this.title = post.getTitle();
		this.description = post.getDescription();
		this.user = post.getUser();
	}
}
