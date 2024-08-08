package com.blog.site.service;

import java.time.LocalDateTime;
import java.util.List;

import com.blog.site.model.Blog;
import com.blog.site.model.BlogResponse;

public interface IBlogService {

	List<Blog> getBlogsByCategory(String category);

	List<BlogResponse> getBlogsByDuration(String category, LocalDateTime durationFromRange, LocalDateTime durationToRange);

}
