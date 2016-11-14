package com.webonise.userCrud.modules

import com.google.inject.AbstractModule
import com.google.inject.Singleton
import com.webonise.userCrud.providers.ApplicationPropertiesProvider
import groovy.transform.CompileStatic

@CompileStatic
class ApplicationPropertiesModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(Properties).toProvider(ApplicationPropertiesProvider).in(Singleton)
    }
}
