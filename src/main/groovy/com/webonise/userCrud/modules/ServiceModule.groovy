package com.webonise.userCrud.modules

import com.google.inject.AbstractModule
import com.google.inject.Singleton
import com.webonise.userCrud.services.impl.UserServiceImpl
import com.webonise.userCrud.services.interfaces.UserService
import groovy.transform.CompileStatic

@CompileStatic
class ServiceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(UserService).to(UserServiceImpl).in(Singleton)
    }
}
