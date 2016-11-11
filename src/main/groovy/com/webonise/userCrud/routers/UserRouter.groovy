package com.webonise.userCrud.routers

import com.webonise.userCrud.resources.CrudResource
import groovy.transform.CompileStatic
import restling.restlet.RestlingRouter

@CompileStatic
class UserRouter extends RestlingRouter {

    @Override
    void init() throws Exception {
        attach("/user", CrudResource)

    }
}
