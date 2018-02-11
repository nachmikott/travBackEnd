package com.trav.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.trav.api.controllers.BlogPostController;
import com.trav.exceptions.PersistenceException;
import com.trav.models.BlogPost;
import com.trav.services.BlogPostService;
import com.trav.utils.PersistenceUtility;

@Service
public class BlogPostServiceImpl implements BlogPostService {

	public static final Logger LOGGER = LoggerFactory.getLogger(BlogPostServiceImpl.class);
	
	
	/**
	 * This method deals with creating a new Blog Post.
	 * 
	 * @param blogPost - The Blog Post trying to be persisted in the DB
	 * @return blogPost - The result of the attempted persistence (can be null)
	 */
	@Override 
	public BlogPost createPost(BlogPost blogPost) {
		try {
			if(blogPost == null) { //Error will be different if the Blog Post object is null
				throw new NullPointerException(); 
			}
			
			/* TODO: For Testing Purposes - At this Point, you should use the AWS SDK to save the blogPost. However, for now, we will 
			   hardcode into the BlogPost that the content is "ERROR" to force an error in this scenario or not
			*/
			if (blogPost.getContent().contains("ERROR")) throw new Exception("error with persistence");
			
			LOGGER.info("Successfully Persisted Blog Post " + blogPost.getBlogPostId());
			return blogPost;
		} catch (Exception exc) { //Catches any exception
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
