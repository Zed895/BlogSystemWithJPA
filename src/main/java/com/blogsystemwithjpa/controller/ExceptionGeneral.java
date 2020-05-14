package com.blogsystemwithjpa.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
* This class is responsible to catch all of the exceptions thrown by the Controller, thus no need separated ExceptionHandlers
* @author Zed
*/
@ControllerAdvice
public class ExceptionGeneral {
	
	/**
	 * This function gives the occured Exception to the Model
	 * @param ex the exception itself what the model receives
	 * @param model the model layer between the controller and the database
	 * @return a html view with the injected exception
	 */
	@ExceptionHandler
	public String exception(Exception ex, Model model) {
		model.addAttribute("exception", ex);
		return "exceptionHandler";
	}

}
