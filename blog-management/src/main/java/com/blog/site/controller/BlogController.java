package com.blog.site.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blog.site.model.Blog;
import com.blog.site.model.BlogResponse;
import com.blog.site.service.IBlogService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/blogs")
public class BlogController {
	
	private Logger logger = LogManager.getLogger(BlogController.class);
	
	@Autowired
	IBlogService blogService;
	
	/**
	 * Fetches the blog based on the given category
	 */
	@GetMapping("/info/{category}")
	@ApiOperation(notes = "getBlogsByCategory", value = "Fetches the blog based on the given category")
	public List<Blog> getBlogsByCategory(
			@ApiParam(name = "category", value = "category to fetch blog") @RequestParam String category) {
		logger.info("Request received to fetch blogs based on category : {}", category);
		return blogService.getBlogsByCategory(category);
	}
	
	/**
	 * Fetches blogs based on the given duration
	 */
	@GetMapping("/get/{category}/{durationFromRange}/{durationToRange}")
	@ApiOperation(notes = "getBlogsByDuration", value = "Fetches blogs based on the given duration")
	public List<BlogResponse> getBlogsByDuration(@ApiParam(name = "category", value = "category to fetch blog") @RequestParam String category,
			@ApiParam(name = "durationFromRange", value = "start duration") @RequestParam LocalDateTime durationFromRange, 
			@ApiParam(name = "durationToRange", value = "end duration") @RequestParam LocalDateTime durationToRange) {
		logger.info("Request received to fetch blogs based on the given duration : {}-{} for category : {}", 
				durationFromRange, durationToRange, category);
		return blogService.getBlogsByDuration(category, durationFromRange, durationToRange);
	}

}
