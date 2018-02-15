package com.trav.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;


/*
 * This model is a Java Object representation of a blogPost.
 * When REST API receives blogPost information in JSON form, 
 * it will be converted into a blogPost Java Object.
 */

@JsonIgnoreProperties(ignoreUnknown = true) /* Lets Jackson ignore any unknown fields in the json payload that 
is not in the BlogPost object */
@Data
public class BlogPost {
	private long blogPostId; 
    
	private long tripId; //Every blogPost is part of an over-arching Trip. 
    
	private String content;
	
	private String location; //TODO: When you start putting together the Maps, find the most suitable type for this field.
    
	private String coverPhotoPointer; /* Every blogPost has a 'cover photo' picture. 
    										This is a URL pointer to an S3 Bucket holding the photo. */
    private List<String> subPicturePointerList;
	
    private String title;
}
