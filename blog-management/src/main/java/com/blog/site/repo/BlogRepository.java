package com.blog.site.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.blog.site.model.Blog;


public interface BlogRepository extends MongoRepository<Blog, String>{

	List<Blog> fetchBlogsByCategory(String category);

}
