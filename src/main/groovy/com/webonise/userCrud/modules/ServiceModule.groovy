package com.webonise.userCrud.modules

import com.google.inject.AbstractModule
import com.google.inject.Singleton
import com.webonise.userCrud.services.impl.DatabaseServiceImpl
import com.webonise.userCrud.services.interfaces.DatabaseService
import groovy.transform.CompileStatic

@CompileStatic
class ServiceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(DatabaseService).to(DatabaseServiceImpl).in(Singleton)
    }
}
