package com.webonise.userCrud.exceptions

import groovy.transform.CompileStatic
import org.restlet.data.Status
import org.restlet.resource.ResourceException

@CompileStatic
class ValidationException extends ResourceException{
    ValidationException(String description) {
        super(Status.CLIENT_ERROR_BAD_REQUEST, description)
    }
}
