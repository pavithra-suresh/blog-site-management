package com.blog.site.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.site.model.Blog;
import com.blog.site.repo.BlogRepository;

@Service
public class UserService implements IUserService {
	
	@Autowired
	BlogRepository blogRepo;

	@Override
	public List<Blog> getBlogsByUser(String user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteBlog(String blogname) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Blog addBlog(Blog blog, String blogname) {
		// TODO Auto-generated method stub
		return null;
	}

}
