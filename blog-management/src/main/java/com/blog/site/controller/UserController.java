package com.blog.site.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blog.site.model.Blog;
import com.blog.site.service.IUserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private Logger logger = LogManager.getLogger(UserController.class);
	
	@Autowired
	IUserService userService;
	
	/**
	 * Fetches all the blogs of the user
	 */
	@GetMapping("/getall/{user}")
	@ApiOperation(notes = "getBlogsByUser", value = "Fetches all the blogs of the user")
	public List<Blog> getBlogsByUser(
			@ApiParam(name = "user", value = "username to fetch blog") @RequestParam String user) {
		logger.info("Request received to fetch blogs based on user : {}", user);
		return userService.getBlogsByUser(user);
	}

	/**
	 * Deletes a blog
	 */
	@DeleteMapping("/delete/{blogname}")
	@ApiOperation(notes = "deleteBlog", value = "Deletes a blog")
	public boolean deleteBlog(
			@ApiParam(name = "blogName", value = "blogName to delete") @RequestParam String blogName,
			@ApiParam(name = "userName", value = "username to delete blog") 
			@RequestHeader (name = "user-name", required = true) String userName) {
		logger.info("Request received to delete a blog : {}", blogName);
		return userService.deleteBlog(blogName, userName);
	}
	
	/**
	 * Add new blog to the system
	 */
	@PostMapping("/blogs/add")
	@ApiOperation(notes = "addBlog", value = "Add new blog to the system")
	public Blog addBlog(@ApiParam(name = "blog", value = "Blog details to be created") @RequestBody Blog blog) {
		logger.info("Request received to add new blog : {} with name : {}", blog);
		return userService.addBlog(blog);
	}
	
}
