package org.bidding.utils.preconditions;

import org.bidding.utils.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;

/**
 * Simple static methods to be called at the start of your own methods to verify correct arguments and state. If the Precondition fails, an {@link HttpStatus} code is thrown
 */
public final class RestPreconditions {

    private RestPreconditions() {
        throw new AssertionError();
    }

    /**
     * Check if some value was found, otherwise throw exception.
     * 
     * @param expression
     *            has value true if found, otherwise false
     * @throws MyResourceNotFoundException
     *             if expression is false, means value not found.
     */
    public static void checkFound(final boolean expression) {
        if (!expression) {
            throw new ResourceNotFoundException(1);
        }
    }

    /**
     * Check if some value was found, otherwise throw exception.
     * 
     * @param expression
     *            has value true if found, otherwise false
     * @throws MyResourceNotFoundException
     *             if expression is false, means value not found.
     */
    public static <T> T checkFound(final T resource) {
        if (resource == null) {
            throw new ResourceNotFoundException(1);
        }

        return resource;
    }
    
    public static <T> T checkIfEmpty(final T resource) {
    	// TODO: Check if resource is instance of a list, if yes, proceed
    		// TODO: Check if resource has size 0, if yes, return true 
    	return resource;
    }

}
