package org.fpt.utils;

import org.fpt.handlers.exceptions.ResourceNotFoundException;

public final class RestPreconditions {

    private RestPreconditions() {
        throw new AssertionError();
    }

    public static void checkFound(final boolean expression) {
        if(!expression) {
            throw new ResourceNotFoundException();
        }
    }

    public static <T> T checkFound(final T resource) {
        if(resource == null) {
            throw new ResourceNotFoundException();
        }

        return resource;
    }

}
