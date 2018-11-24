package com.niit.dao;


import java.util.List;

import com.niit.models.BlogPost;

public interface BlogPostdao 
{

	void addBlogPost(BlogPost blogPost);

	List<BlogPost> blogsWaitingForApproval();

	BlogPost getBlog(int blogPostId);

	List<BlogPost> blogsApproved();

	void updateBlogPost(BlogPost blogPost);
	void deleteBlogPost(BlogPost blogPost);
	
}
