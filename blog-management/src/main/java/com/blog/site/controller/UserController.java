package com.blog.site.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.blog.site.model.Blog;
import com.blog.site.service.IUserService;

@RequestMapping("/user")
public class UserController {
	
	private Logger logger = LogManager.getLogger(UserController.class);
	
	@Autowired
	IUserService userService;
	
	/**
	 * Fetches all the blogs of the user
	 */
	@GetMapping("/getall/{user}")
	public List<Blog> getBlogsByUser(@RequestParam String user) {
		logger.info("Request received to fetch blogs based on user : {}", user);
		return userService.getBlogsByUser(user);
	}

	/**
	 * Deletes a blog
	 */
	@DeleteMapping("/delete/{blogname}")
	public boolean deleteBlog(@RequestParam String blogname) {
		logger.info("Request received to delete a blog : {}", blogname);
		return userService.deleteBlog(blogname);
	}
	
	/**
	 * Add new blog to the system
	 */
	@PostMapping("/blogs/add/{blogname}")
	public Blog addBlog(@RequestBody Blog blog, @RequestParam String blogname) {
		logger.info("Request received to add new blog : {} with name : {}", blog, blogname);
		return userService.addBlog(blog, blogname);
	}
	
}
