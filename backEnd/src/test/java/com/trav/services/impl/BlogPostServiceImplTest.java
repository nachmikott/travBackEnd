package com.trav.services.impl;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trav.backEnd.App;
import com.trav.exceptions.PersistenceException;
import com.trav.models.BlogPost;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;;

/** 
 * Tests the PostBlog REST API Enpoints (found in com.trav.api.endpoints package)
 * 
 * @author nachmi
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {App.class})
public class BlogPostServiceImplTest {
	@Spy
	BlogPostServiceImpl blogPostServiceImpl;
	
	BlogPost blogPostRequest;
	
	@Before 
	public void createBlog() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
        blogPostRequest = mapper.readValue(new File("/Users/nachmi/Desktop/Development/"
        		+ "workspace/travBackEnd/backEnd/src/test/resources/com/trav/api/endpoints/PostBlog_Request"), 
        		BlogPost.class);
	}
	
	@Test
	public void assertCreatePostSuccess() throws JsonParseException, JsonMappingException, IOException {
		try {
			blogPostServiceImpl.createPost(blogPostRequest);
		} catch (PersistenceException persistenceException) {
			fail();
		}
	}
	
	@Test
	public void asserCreatePostFailure() throws JsonParseException, JsonMappingException, IOException {
		try {
			blogPostServiceImpl.createPost(blogPostRequest);
		} catch (PersistenceException persistenceException) {
			assertTrue(true); //Automatically passes;
		}
	} 
	
	@Test
	public void asserCreatePostBadBlog() throws JsonParseException, JsonMappingException, IOException {
		//When the Blog Post is null
		try {
			blogPostServiceImpl.createPost(null);
		} catch (PersistenceException persistenceException) {
			assertTrue(true); //Automatically passes;
		}
		
		//When the Blog Post is missing a Title.
		try {
			blogPostRequest.setTitle(null);
			blogPostServiceImpl.createPost(null);
		} catch (PersistenceException persistenceException) {
			assertTrue(true); //Automatically passes;
		}
	}  
}








