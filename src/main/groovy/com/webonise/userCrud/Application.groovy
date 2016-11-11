package com.webonise.userCrud

import com.webonise.userCrud.modules.DaoModule
import com.webonise.userCrud.modules.ServiceModule
import com.webonise.userCrud.routers.RootRouter
import groovy.transform.CompileStatic
import restling.guice.modules.RestlingApplicationModule

@CompileStatic
class Application extends RestlingApplicationModule {

    Class<RootRouter> routerClass = RootRouter

    @Override
    void configureCustomBindings() {
        install(new DaoModule())
        install(new ServiceModule())
    }

}
