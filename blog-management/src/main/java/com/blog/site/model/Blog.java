package com.blog.site.model;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.data.mongodb.core.mapping.Document;

import com.blog.site.util.WordCount;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "blog")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Blog {
	
	@NotEmpty(message = "Blog name should not be empty")
	@Size(min = 20, message = "Blog Name should be of minimum 20 characters")
	private String blogName;
	
	@NotEmpty(message = "Category should not be empty")
	@Size(min = 20, message = "Blog Name should be of minimum 20 characters")
	private String category;
	
	// The @WordCount custom annotation is applied to the content field
	@WordCount(min = 1000, message = "Article should be of minimum 1000 words")
	@NotEmpty(message = "Article should not be empty")
	private String article;
	
	@NotEmpty(message = "Author name should not be empty")
	private String authorName;
	
	private LocalDateTime timestamp;

}
