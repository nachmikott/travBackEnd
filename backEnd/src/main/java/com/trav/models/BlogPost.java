package com.trav.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/*
 * This model is a Java Object representation of a blogPost.
 * When REST API receives blogPost information in JSON form, 
 * it will be converted into a blogPost Java Object.
 */

@JsonIgnoreProperties(ignoreUnknown = true) /* Lets Jackson ignore any unknown fields in the json payload that 
is not in the BlogPost object */
public class BlogPost {
	private long blogPostId; 
    private long tripId; //Every blogPost is part of an over-arching Trip. 
    private String content;
    private String coverPhotoPointer; /* Every blogPost has a 'cover photo' picture. 
    										This is a URL pointer to an S3 Bucket holding the photo. */
    private List<String> subPicturePointerList;
	private String title;
    
	public long getBlogPostId() {
		return blogPostId;
	}
	public void setBlogPostId(long blogPostId) {
		this.blogPostId = blogPostId;
	}
	public long getTripId() {
		return tripId;
	}
	public void setTripId(long tripId) {
		this.tripId = tripId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getMainPicturePointer() {
		return coverPhotoPointer;
	}
	public void setMainPicturePointer(String coverPhotoPointer) {
		this.coverPhotoPointer = coverPhotoPointer;
	}
	public List<String> getSubPicturePointerList() {
		return subPicturePointerList;
	}
	public void setSubPicturePointerList(List<String> subPicturePointerList) {
		this.subPicturePointerList = subPicturePointerList;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle(String title) {
		return this.title;
	}
}
