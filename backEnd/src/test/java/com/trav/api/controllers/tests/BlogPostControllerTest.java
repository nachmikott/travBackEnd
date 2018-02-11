package com.trav.api.controllers.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trav.api.controllers.BlogPostController;
import com.trav.backEnd.App;
import com.trav.exceptions.PersistenceException;
import com.trav.models.BlogPost;
import com.trav.services.BlogPostService;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/** 
 * Tests the PostBlog REST API Enpoints (found in com.trav.api.endpoints package)
 * 
 * @author nachmi
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {App.class})
public class BlogPostControllerTest {
	
	@Spy
	BlogPostController blogPostController;
	
	@Mock
	BlogPostService blogPostService;
	
	@Before
	public void setUpBlogPostController() {
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(blogPostController, "blogPostService", blogPostService);
	}
	
	@Test
	public void assertPostBlogSuccess() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
        BlogPost blogPostRequest = mapper.readValue(new File("/Users/nachmi/Desktop/Development/"
        		+ "workspace/travBackEnd/backEnd/src/test/resources/com/trav/api/endpoints/PostBlog_Request"), 
        		BlogPost.class); 
        
        Mockito.when(blogPostService.createPost(Mockito.any(BlogPost.class))).thenReturn(blogPostRequest);
        
        //Initiate Test
        ResponseEntity<BlogPost> result = blogPostController.postBlog(blogPostRequest);
        
        //Verifying the BlogPostService called CreatePost
        Mockito.verify(blogPostService, Mockito.times(1)).createPost(Mockito.any(BlogPost.class));
        //Verifying the Controller will return a 200 
        assertEquals(result.getStatusCode(), HttpStatus.ACCEPTED);
        //Verifying the Result Body is not null.
        assertNotNull(result.getBody());
	}
	
	@Test
	public void assertPostBlogFailure() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
        BlogPost blogPostRequest = mapper.readValue(new File("/Users/nachmi/Desktop/Development/"
        		+ "workspace/travBackEnd/backEnd/src/test/resources/com/trav/api/endpoints/PostBlog_Request"), 
        		BlogPost.class);

        Mockito.doThrow(new PersistenceException("error")).when(blogPostService).createPost(Mockito.any(BlogPost.class));
       
        //Initiate Test
        ResponseEntity<BlogPost> result = blogPostController.postBlog(blogPostRequest);
        
        //Verifying the BlogPostService called CreatePost
        Mockito.verify(blogPostService, Mockito.times(1)).createPost(Mockito.any(BlogPost.class));
        //Verifying the Controller will return a 200 
        assertEquals(result.getStatusCode(), HttpStatus.SERVICE_UNAVAILABLE);
        //Verifying the result body is null
        assertNull(result.getBody());
	}  
}







