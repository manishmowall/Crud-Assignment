package com.webonise.userCrud.modules

import com.google.inject.AbstractModule
import com.google.inject.Provides
import org.jooq.DSLContext
import org.jooq.SQLDialect
import org.jooq.impl.DSL

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

class DaoModule extends AbstractModule {

    @Override
    protected void configure() {

    }

    @Provides
    DSLContext provideMysqlContext() throws SQLException {
        String userName = "root"
        String password = ""
        String url = "jdbc:mysql://localhost:3306/Users"

        Connection connection = DriverManager.getConnection(url, userName, password)

        return DSL.using(connection, SQLDialect.MYSQL);
    }
}
