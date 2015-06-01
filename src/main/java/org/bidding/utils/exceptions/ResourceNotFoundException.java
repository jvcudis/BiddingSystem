package org.bidding.utils.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such resource.")
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(Integer resourceId) {
		super("Resource with ID " + resourceId + " not found.");
	}
	
	public ResourceNotFoundException(final String message) {
       super(message);
    }
	
	public ResourceNotFoundException(final String className, final Integer resourceId) {
		super("Resource with class " + className + " and ID " + resourceId + "not found.");
	}
}
