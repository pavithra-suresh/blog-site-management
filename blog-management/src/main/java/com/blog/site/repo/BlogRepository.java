package com.blog.site.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.blog.site.model.Blog;


public interface BlogRepository extends MongoRepository<Blog, String>{

	List<Blog> findByCategory(String category);
	
	List<Blog> findByAuthorName(String authorName);
	
	Blog findByBlogName(String blogName);

	@Query("{ 'category' : ?0, 'timestamp' : { $gte: ?1, $lte: ?2 } }")
	List<Blog> fetchBlogsByDuration(String category, LocalDateTime durationFromRange, 
			LocalDateTime durationToRange);

}
