package com.blogsystemwithjpa.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.ServletWebRequest;

/**
* This class handles the status errors.
* @author Zed
*/
@Controller
public class ErrorPageController implements ErrorController{
	
	private static final String ERR_PATH = "/error"; //needed at two places so moved here as global variable.
	
	private ErrorAttributes errorAttributes; //It's from Spring.
	
	/**
	 * Injects errorAttributes into this class when this class is instantiated.
	 * @param errorAttributes this will be injected.
	 */
	@Autowired
	public void SetErrorAttributes(ErrorAttributes errorAttributes) {
		this.errorAttributes = errorAttributes;
	}
	
	/**
	 * If the user is redirected to the ERR_PATH then this function catch it and injects the error related attributes of the request into the proper error handling view then redirects the user to there.
	 * @param model the model from the framework.
	 * @param request the Http request.
	 * @return an error handling view.
	 */
	@RequestMapping(ERR_PATH)
	public String error(Model model, HttpServletRequest request) { //ez a request maga, azt kerjuk argumentumkent, meg egy Model-t
		ServletWebRequest rA = new ServletWebRequest(request); //filter only to the attributes of the request.
		Map<String, Object> error = this.errorAttributes.getErrorAttributes(rA, true); //filters the error-related attributes into a map.
		//send them to the frontend:
		model.addAttribute("timestamp", error.get("timestamp"));
		model.addAttribute("error", error.get("error"));
		model.addAttribute("message", error.get("message"));
		model.addAttribute("path", error.get("path"));
		model.addAttribute("status", error.get("status"));
		
		if (error.get("path").equals("/admin")) return "adminError";
		if ((int) error.get("status") == 404) return notFound(model, request);
		return "detailedError";
	}
	
	/**
	 * This function can be called by the error() one and redirects the user to the 404 error page.
	 * @param model the model from the framework.
	 * @param request the Http request.
	 * @return the 404 error view.
	 */
	public String notFound(Model model, HttpServletRequest request) {
		return "404";
	}
	
	/**
	 * This function is from the implemented interface.
	 * It defines where redirect the user to in case of error.
	 * @return the value of the ERR_PATH constans. The user will be redirected to there.
	 */
	@Override
	public String getErrorPath() {
		return ERR_PATH; //to the /error.html which is cought above.
	}

}
