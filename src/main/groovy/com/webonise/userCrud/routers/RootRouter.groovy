package com.webonise.userCrud.routers

import groovy.transform.CompileStatic
import restling.restlet.RestlingRouter

@CompileStatic
class RootRouter extends RestlingRouter {

    @Override
    void init() throws Exception {
        attachSubRouter("/api",ApiRouter);
    }
}
