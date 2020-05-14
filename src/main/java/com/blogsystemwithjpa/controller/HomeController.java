package com.blogsystemwithjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blogsystemwithjpa.domain.Story;
import com.blogsystemwithjpa.repository.StoryRepository;
import com.blogsystemwithjpa.service.StoryService;

import java.util.List;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;

/**
* This class is a controller layer, searches for views (html pages) when a request arrives.
* It is Singleton.
* @author Zed
*/
@Controller
public class HomeController {
	
	private StoryService storyService;
	@Autowired //Always the same will be injected regardless who sees how many times the webpage.
	public void setStoryService(StoryService storyService) {
		this.storyService = storyService;
	}

	/**
	 * Returns the stories view with injected content if a request arrives to the "/" URL.
	 * The injected contents are the page title and story objects (with title, content, posted date and bloggers).
	 * @param model a model from the spring framework
	 * @param locale to get the location of the user
	 * @return the stories html view.
	 */
	@RequestMapping("/")
	public String stories(Model model, Locale locale) {
		model.addAttribute("pageTitle", "Test page title");//model receives the key (same as it is called on the frontend side) and the value.
		model.addAttribute("stories", storyService.getStories()); //model receives a List (stories) of objects (story) from the DB.
		System.out.println(String.format("Request received. Language: %s, Country: %s %n",locale.getLanguage(), locale.getDisplayCountry()));
		return "stories";
	}

}
