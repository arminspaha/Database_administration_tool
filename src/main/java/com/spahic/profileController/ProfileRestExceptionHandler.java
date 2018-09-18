package com.spahic.profileController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProfileRestExceptionHandler {
	
	// add an exception handler for ProfileNotFoundExpcetion
	@ExceptionHandler
	public ResponseEntity<ProfileErrorResponse> handleException(ProfileNotFoundException exc) {
		
		// create ProfileErrorResponse
		ProfileErrorResponse error = new ProfileErrorResponse(
				HttpStatus.NOT_FOUND.value(),
				exc.getMessage(),
				System.currentTimeMillis());
		
		//return ResponseEntity		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	
	// add another exception handler to catch any exception
	@ExceptionHandler
	public ResponseEntity<ProfileErrorResponse> handleException(Exception exc) {
		
		// create CustomerErrorResponse
		ProfileErrorResponse error = new ProfileErrorResponse(
				HttpStatus.BAD_REQUEST.value(),
				exc.getMessage(),
				System.currentTimeMillis());
		
		//return ResponseEntity		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
