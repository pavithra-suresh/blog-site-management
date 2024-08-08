package com.blog.site.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.blog.site.model.Blog;
import com.blog.site.repo.BlogRepository;

public class BlogService implements IBlogService {
	
	private Logger logger = LogManager.getLogger(BlogService.class);

	@Autowired
	BlogRepository blogRepository;
	
	@Override
	public List<Blog> getBlogsByCategory(String category) {
		List<Blog> blogsByCategory = blogRepository.fetchBlogsByCategory(category);
		logger.info("Fetched blogs based on category - {} : {}", category, blogsByCategory);
		return blogsByCategory;
	}

	@Override
	public List<Blog> getBlogsByDuration(String category, String durationFromRange, String durationToRange) {
		// TODO Auto-generated method stub
		return null;
	}

}
