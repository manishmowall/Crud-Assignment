package com.webonise.userCrud.modules

import com.google.inject.AbstractModule
import com.google.inject.Singleton
import com.webonise.userCrud.providers.DSLContextProvider
import groovy.transform.CompileStatic
import org.jooq.DSLContext

@CompileStatic
class DaoModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(DSLContext).toProvider(DSLContextProvider).in(Singleton)
    }
}
