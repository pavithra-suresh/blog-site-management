package com.blog.site.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.blog.site.model.Blog;
import com.blog.site.service.IBlogService;

@RequestMapping("/blogs")
public class BlogController {
	
	private Logger logger = LogManager.getLogger(BlogController.class);
	
	@Autowired
	IBlogService blogService;
	
	/**
	 * Fetches the blog based on the given category
	 */
	@GetMapping("/info/{category}")
	public List<Blog> getBlogsByCategory(@RequestParam String category) {
		logger.info("Request received to fetch blogs based on category : {}", category);
		return blogService.getBlogsByCategory(category);
	}
	
	/**
	 * Fetches blogs based on the given duration
	 */
	@GetMapping("/get/{category}/{durationFromRange}/{durationToRange}")
	public List<Blog> getBlogsByDuration(@RequestParam String category,
			@RequestParam String durationFromRange, 
			@RequestParam String durationToRange) {
		logger.info("Request received to fetch blogs based on the given duration : {}-{} for category : {}", 
				durationFromRange, durationToRange, category);
		return blogService.getBlogsByDuration(category, durationFromRange, durationToRange);
	}

}
