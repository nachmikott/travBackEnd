package com.trav.services;

import org.springframework.stereotype.Service;
import com.trav.models.BlogPost;

/**
 * This Blog Post Service Is In Charge of All Actions involved in Database Alterations/Interactions.
 * 
 * @author nachmi
 *
 */

public interface BlogPostService {
	
	public BlogPost createPost(BlogPost blogPost); /* C - create a Blog Post, creates it to the DB */
	
	public BlogPost readPost(BlogPost blogPost); /* R - read a Blog Post, selects it from the DB */ 
	
	public BlogPost updateBlogPost(BlogPost blogPost); /* U - updates a Blog Post, updates it from the DB */
	
	public void deleteBlogPost(BlogPost blogPost); /* D - deletes a Blog Post, delets it from the DB */
}
