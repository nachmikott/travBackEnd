package com.trav.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.trav.api.controllers.BlogPostController;
import com.trav.exceptions.PersistenceException;
import com.trav.models.BlogPost;
import com.trav.services.BlogPostService;

@Service
public class BlogPostServiceImpl implements BlogPostService {

	public static final Logger LOGGER = LoggerFactory.getLogger(BlogPostServiceImpl.class);
	
	@Override
	public BlogPost createPost(BlogPost blogPost) {
		try {
			if(blogPost == null) { throw new NullPointerException(); }
			System.out.println("We are within the Try Block of BlogPostServiceImpl.createPost())");
			blogPost.setContent("SUCCESS");
			LOGGER.info("Successfully Persisted Blog Post " + blogPost.getBlogPostId());
			return blogPost;
		} catch (Exception exc) {
			String reason = null;
			if (exc.getClass().equals(NullPointerException.class)) { 
				reason = "The BlogPost is null! That's no good!";
			} else {
				reason = "Couldn't save the BlogPost " + blogPost.getBlogPostId() + "because of a PersistenceException : " + exc;
			}
			LOGGER.error(reason);
			throw new PersistenceException(exc.toString());
		}
	}

	@Override
	public BlogPost readPost(BlogPost blogPost) {
		System.out.println("Reading Post");
		return null;
	}

	@Override
	public BlogPost updateBlogPost(BlogPost blogPost) {
		System.out.println("Updating Post");
		return null;
	}

	@Override
	public void deleteBlogPost(BlogPost blogPost) {
		System.out.println("Deleting Post");
	}

}
