package com.kzt.blog.web.forms;

import javax.validation.constraints.NotBlank;

import com.kzt.blog.bl.dto.post.PostDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostForm {
	private Long id;

	@NotBlank(message = "Title field is required")
	private String title;
	
	@NotBlank(message = "Description field is required")
	private String description;
	
//	@NotBlank(message = "User Name field is required")
	private Long userId;
	
	public PostForm(PostDTO postDTO) {
		this.id = postDTO.getId();
		this.title = postDTO.getTitle();
		this.description = postDTO.getDescription();
		this.userId = postDTO.getUser().getId();
	}
}

