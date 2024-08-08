package com.blog.site.model;

import java.time.LocalDateTime;

/**
 * Builder Pattern of Creational Design Pattern used for composing a model object. 
 * 
 * Defining BlogResponse Model
 * @author Pavi
 *
 */
public class BlogResponse {
	

	private String blogName;
	private String category;
	private String article;
	private String authorName;
	private LocalDateTime timestamp;
	
	private BlogResponse(BlogBuilder builder) {
		this.blogName = builder.blogName;
		this.category = builder.category;
		this.article = builder.article;
		this.authorName = builder.authorName;
		this.timestamp = builder.timestamp;
	}

	// Blog Response Builder
	public static class BlogBuilder {
		private String blogName;
		private String category;
		private String article;
		private String authorName;
		private LocalDateTime timestamp;
		
		public BlogBuilder withBlogName(String blogName) {
			this.blogName = blogName;
			return this;
		}
		
		public BlogBuilder withCategory(String category) {
			this.category = category;
			return this;
		}
		
		public BlogBuilder withArticle(String article) {
			this.article = article;
			return this;
		}
		
		public BlogBuilder withAuthorName(String authorName) {
			this.authorName = authorName;
			return this;
		}
		
		public BlogBuilder withTimestamp(LocalDateTime timestamp) {
			this.timestamp = timestamp;
			return this;
		}
		
		
		// The Builder pattern is used to create instances of this model
		public BlogResponse build() {
			return new BlogResponse(this);
		}
		
	}

	@Override
	public String toString() {
		return "BlogResponse [blogName=" + blogName + ", category=" + category + ", article=" + article
				+ ", authorName=" + authorName + ", timestamp=" + timestamp + "]";
	}
	
	
}
