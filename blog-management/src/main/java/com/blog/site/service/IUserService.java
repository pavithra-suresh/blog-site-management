package com.blog.site.service;

import java.util.List;

import com.blog.site.model.Blog;


public interface IUserService {

	List<Blog> getBlogsByUser(String userName);

	boolean deleteBlog(String blogName, String userName);

	Blog addBlog(Blog blog);

}
