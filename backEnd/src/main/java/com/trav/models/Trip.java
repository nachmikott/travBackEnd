package com.trav.models;

import java.util.Date;
import java.util.List;
import java.util.Stack;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.trav.enums.CategoryType;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)  /* Lets Jackson ignore any unknown fields in the json payload that 
is not in the BlogPost object */
@Data
public class Trip {
	private long tripId;
	
	private Date tripStartDate;
	
	private Date tripEndDate;
	
	private String tripTitle;
	
	private List<CategoryType> categoryTags;
	
	private String tripCoverPhotoUrl;
	
	private Stack<BlogPost> blogPosts;
}
