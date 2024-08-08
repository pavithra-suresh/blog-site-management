package com.blog.site.service;

import java.util.List;

import com.blog.site.model.Blog;


public interface IUserService {

	List<Blog> getBlogsByUser(String user);

	boolean deleteBlog(String blogname);

	Blog addBlog(Blog blog, String blogname);

}
