package com.blogsystemwithjpa.service;

import java.util.List;
//import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogsystemwithjpa.domain.Story;
import com.blogsystemwithjpa.repository.BloggerRepository;
import com.blogsystemwithjpa.repository.StoryRepository;

/**
 * This class is the Service layer for business logic, calculations.
 * It is Singleton, since service.
 * Always the same will be injected regardless who sees how many times the webpage, everybody receives the same single service.
 * @author Zed
 */
@Service
public class StoryService {
	
	private StoryRepository storyRepo;
	@Autowired
	public void setStoryRepo(StoryRepository storyRepo) {
		this.storyRepo = storyRepo;
	}
	
	private BloggerRepository bloggerRepo;
	@Autowired
	public void setBloggerRepo(BloggerRepository bloggerRepo) {
		this.bloggerRepo = bloggerRepo;
	}
	
	/**
	 * Returns the stories from the repo.
	 * @return all of the stories
	 */
	public List<Story> getStories() {
		return storyRepo.findAll();
	}
	
	/**
	 * Returns the first story (by posted time) from the repo.
	 * @return a single story.
	 */
	public Story getStory() {
		return storyRepo.findFirstByOrderByPostedDesc();
	}
	
	/**
	 * Returns stories with the requested title from the repo.
	 * @param title a story title
	 * @return a story.
	 */
	public Story getSpecificStory(String title) { //check later if it is null then exception handling.
		return storyRepo.findByTitleIgnoreCase(title);
	}
	
	/**
	 * Returns all of the stories written by the same blogger from the repo.
	 * @param name a blogger name
	 * @return stories.
	 */
	public List<Story> getStoriesByBloggerName(String name) {
		return storyRepo.findAllByBloggerNameIgnoreCaseOrderByPostedDesc(name);
	}
	
//	/**
//	 * Container calls it once when the service is intantiated.
//	 * Creates a story and a blogger in the HEAP, then JPA saves it via extended CrudRepository.
//	 */
//	@PostConstruct
//	public void init() {
//		Blogger blogger = new Blogger("Inner John", 25); //not from the Container but theoretically from the users.
//		bloggerRepo.save(blogger);
//		Story story = new Story("Inner title from code", "Inner content from code", new Date(), blogger);
//		storyRepo.save(story);
//	}

}
