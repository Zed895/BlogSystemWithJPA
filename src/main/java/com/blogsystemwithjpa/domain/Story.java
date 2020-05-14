package com.blogsystemwithjpa.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.blogsystemwithjpa.repository.BloggerRepository;

/**
* This class represents a story entity in the DB.
* @author Zed
*/
@Entity(name = "stories") //Hibernate needs this annotation. "stories" in the DB.
public class Story {	
	
	@GeneratedValue(strategy=GenerationType.IDENTITY) //by the DB
	@Id //it will be the primary key
	private Long id;
	//@Column(name = "cim") //if it had a different field name in the other DB.
	private String title;
	@Column(columnDefinition = "TEXT")
	private String content;
	private Date posted;
	@ManyToOne //many stories to one Blogger
	private Blogger blogger;
	
	/**
	 * Constructor to create a story object via JPA.
	 */
	private Story() {
	}
	
	/**
	 * Constructor to create a story object from the View, not from the SQL files.
	 * @param title the title of the new story
	 * @param content the content of the new story
	 * @param posted the date when it was posted
	 * @param blogger the name of the blogger who posted the new story
	 */
	public Story(String title, String content, Date posted, Blogger blogger) {												
		this.title = title;
		this.content = content;
		this.posted = posted;
		this.blogger = blogger;
	}
	
	//getters and setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getPosted() {
		return posted;
	}
	public void setPosted(Date posted) {
		this.posted = posted;
	}
	public Blogger getBlogger() {
		return blogger;
	}
	public void setBlogger(Blogger author) {
		this.blogger = author;
	}

//	@Override
//	public String toString() {
//		return "Story [title=" + title + "]";
//	}

}
