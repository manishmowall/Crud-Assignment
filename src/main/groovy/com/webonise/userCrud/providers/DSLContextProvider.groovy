package com.webonise.userCrud.providers

import com.google.inject.Inject
import com.google.inject.Provider
import groovy.transform.CompileStatic
import org.jooq.DSLContext
import org.jooq.SQLDialect
import org.jooq.impl.DSL

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

@CompileStatic
class DSLContextProvider implements Provider<DSLContext> {
    private final Properties properties

    @Inject
    DSLContextProvider(Properties properties) {
        this.properties = properties
    }

    @Override
    DSLContext get() throws SQLException {
        String userName = properties.getProperty("MYSQL_USER_LOGIN")
        String password = properties.getProperty("MYSQL_USER_PASSWORD")
        String url = properties.getProperty("MYSQL_DB_URL")
        Connection connection = DriverManager.getConnection(url, userName, password)
        return DSL.using(connection, SQLDialect.MYSQL)
    }
}
