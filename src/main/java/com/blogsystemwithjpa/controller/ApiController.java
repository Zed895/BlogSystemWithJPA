package com.blogsystemwithjpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogsystemwithjpa.domain.Story;
import com.blogsystemwithjpa.service.StoryService;

/**
* This class is a RestController layer, when a specific request arrives it sends back raw data.
* @author Zed
*/
@RestController
public class ApiController {
	
	private StoryService storyService;
	@Autowired
	public void setStoryService(StoryService storyService) {
		this.storyService = storyService;
	}
	
	/**
	 * If a request arrives to the "/story" URL then it returns the newest story object.
	 * @return the newest story.
	 */
	@RequestMapping("/story")
	public Story story() {//model removed, it does not go the the frontend now.
		return storyService.getStory();
		//return storyService.getStory().toString(); //to get it as a String
	}
	
	/**
	 * If a request arrives to the "/title/" URL then it returns the story with the specified title.
	 * @param title the title of the searched story.
	 * @return the requested story.
	 */
	@RequestMapping("/title/{title}")
	public Story searchForStory(@PathVariable(value="title") String title){
		return storyService.getSpecificStory(title);
	}
	
	/**
	 * If a request arrives to the "/stories/" URL then it returns the stories written by the specified blogger.
	 * It gets them from the storyRepo though it filters by blogger.
	 * @param name the name of the blogger.
	 * @return the stories written by the same blogger.
	 */
	@RequestMapping("/stories/{name}")
	public List<Story> searchStoriesByBloggerName(@PathVariable(value="name") String name){
		return storyService.getStoriesByBloggerName(name);
	}

}
