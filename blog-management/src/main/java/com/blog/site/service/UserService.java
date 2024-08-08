package com.blog.site.service;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.site.model.Blog;
import com.blog.site.repo.BlogRepository;

@Service
public class UserService implements IUserService {
	
	private Logger logger = LogManager.getLogger(UserService.class);
	
	@Autowired
	BlogRepository blogRepo;

	/**
	 * Method to view the blog created by the user
	 */
	@Override
	public List<Blog> getBlogsByUser(String userName) {
		logger.info("Get blogs created by the user : {}", userName);
		List<Blog> blogs = blogRepo.findByAuthorName(userName);
		
		logger.info("Blogs fetched by user : {} - {}", userName, blogs);
		return null;
	}

	/**
	 * Method to delete only blog created by user from the system
	 */
	@Override
	public boolean deleteBlog(String blogName, String userName) {
		logger.info("Delete blog : {} by user : {}", blogName);
		Blog blog = blogRepo.findByBlogName(blogName);
		
		if(blog.getAuthorName() == userName) {
			logger.info("Deleting blog of User...");
			blogRepo.deleteById(blog.getBlogId());
			return true;
		}
		
		logger.error("UserService :: Error in deletion - Blog doesn't belong to User");
		return false;
	}

	/**
	 * Method to add any new blog to the system
	 */
	@Override
	public Blog addBlog(Blog blog) {
		logger.info("Add blog to system : {}", blog);
		blog.setTimestamp(LocalDateTime.now());
		
		Blog savedBlog = blogRepo.save(blog);
		logger.info("Saved blog : {}", savedBlog);
		return savedBlog;
	}

}
