package com.blogsystemwithjpa.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
* This class represents a blogger entity in the DB.
* @author Zed
*/
@Entity
public class Blogger {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY) //by the DB
	@Id //it will be primary key
	private Long id; //private, encapsulated
	private String name;
	private int age;
	@JsonBackReference
	@OneToMany(mappedBy = "blogger") //param: I am the boss in this relation
	private List<Story> stories; //A blogger could have more stories in this list.
	
	/**
	 * Constructor to create a blogger object via JPA.
	 */
	private Blogger() {
	}	
	
	/**
	 * Constructor to create a blogger object from the View, instead of the SQL files.
	 * @param name the name of the new blogger
	 * @param age the age of the new blogger
	 */
	public Blogger(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
//	public Blogger(Long id, String name, int age) { //for JDBC
//		this.id = id;
//		this.name = name;
//		this.age = age;
//	}
	
	//getters and setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<Story> getStories() {
		return stories;
	}
	public void setStories(List<Story> stories) {
		this.stories = stories;
	}
	
	//For debug
//	@Override
//	public String toString() {
//		return "Blogger [id=" + id + ", name=" + name + ", age=" + age + ", stories=" + stories + "]";
//	}
	
}
