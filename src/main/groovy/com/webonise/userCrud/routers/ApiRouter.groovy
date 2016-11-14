package com.webonise.userCrud.routers

import com.webonise.userCrud.resources.UserResource
import groovy.transform.CompileStatic
import restling.restlet.RestlingRouter

@CompileStatic
class ApiRouter extends RestlingRouter {

    @Override
    void init() throws Exception {
        attach("/user", UserResource)

    }
}
