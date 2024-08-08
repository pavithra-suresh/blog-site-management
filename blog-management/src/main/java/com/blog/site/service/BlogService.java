package com.blog.site.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.blog.site.model.Blog;
import com.blog.site.model.BlogResponse;
import com.blog.site.repo.BlogRepository;

public class BlogService implements IBlogService {
	
	private Logger logger = LogManager.getLogger(BlogService.class);

	@Autowired
	BlogRepository blogRepository;
	
	/**
	 * List the blogs based on provided category
	 */
	@Override
	public List<Blog> getBlogsByCategory(String category) {
		logger.info("Fetches blogs based on category : {}", category);
		
		List<Blog> blogsByCategory = blogRepository.findByCategory(category);
		logger.info("Fetched blogs based on category - {} : {}", category, blogsByCategory);
		return blogsByCategory;
	}

	/**
	 * Method to display blog based on category and duration for blogs created within some dates
	 */
	@Override
	public List<BlogResponse> getBlogsByDuration(String category, LocalDateTime durationFromRange, LocalDateTime durationToRange) {
		
		logger.info("Fetch blogs based on category : {} for duration - {} : {}", 
				category, durationFromRange, durationToRange);
		
		List<Blog> blogs = blogRepository.fetchBlogsByDuration(category, durationFromRange, durationToRange);
		
		// Builder Design Pattern
		return blogs.stream()
				.map(blog -> new BlogResponse.BlogBuilder()
						.withBlogName(blog.getBlogName())
						.withCategory(blog.getCategory())
						.withAuthorName(blog.getAuthorName())
						.withArticle(blog.getArticle())
						.withTimestamp(blog.getTimestamp())
						.build())
				.collect(Collectors.toList());
	}

}
