package com.trav.api.controllers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.trav.exceptions.PersistenceException;
import com.trav.models.BlogPost;
import com.trav.services.BlogPostService;

/**
 * REST Layer For Blog Post API Calls
 * 
 * @author nachmi
 *
 */

@RestController /* Lets Spring know that this is a REST controller */
@Controller /* Lets Spring know that this should be a bean */
public class BlogPostController {
	
	@Autowired
	BlogPostService blogPostService;
 
    public static final Logger LOGGER = LoggerFactory.getLogger(BlogPostController.class);
 
    /* -------------------Post A Blog--------------------- */
 
    @RequestMapping(value = "/blog", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BlogPost> postBlog(@RequestBody BlogPost blogPost) {
        LOGGER.info("Creating Blog Post : {}", blogPost);
        BlogPost result= null;
        
        //Try to Persist The Post 
		try {
			result = blogPostService.createPost(blogPost); //Calling blogPostService in charge of DB interactions
		} catch(PersistenceException persistenceException) { //If there was a failure with DB Interaction, a PersistenceException is thrown
			//Returning the failed version of the ResponseEntity.
			return new ResponseEntity<BlogPost>(result, HttpStatus.SERVICE_UNAVAILABLE);
		}
        
		//Returning the successful version of the ResponseEntity.
        return new ResponseEntity<BlogPost>(result, HttpStatus.ACCEPTED);

    }
}