package com.blog.site.service;

import java.util.List;

import com.blog.site.model.Blog;

public interface IBlogService {

	List<Blog> getBlogsByCategory(String category);

	List<Blog> getBlogsByDuration(String category, String durationFromRange, String durationToRange);

}
