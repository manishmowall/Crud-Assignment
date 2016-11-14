package com.webonise.userCrud.daos

import com.google.inject.Inject
import com.webonise.userCrud.pojos.UserPojo
import com.webonise.userCrud.tables.pojos.User
import com.webonise.userCrud.tables.records.UserRecord
import groovy.transform.CompileStatic
import org.jooq.DSLContext
import org.jooq.Param
import org.jooq.impl.DSL

import static com.webonise.userCrud.tables.User.USER

@CompileStatic
class UserDao {
    private static final String ID_PARAMETER = "ID_PARAMETER"
    private final DSLContext dslContext

    @Inject
    UserDao(DSLContext dslContext) {
        this.dslContext = dslContext
    }

    List<User> getAllUsers() {
        return dslContext.select().from(USER).fetch().into(User)
    }

    User saveUser(UserPojo user) {
        UserRecord userRecord = dslContext.newRecord(USER)
        userRecord.setName(user.getName())
        userRecord.setDateofbirth(user.getDateOfBirth())
        userRecord.store()

        return userRecord.into(User)
    }

    int updateUser(int id, UserPojo user) {
        Param<Integer> idParam = DSL.param(ID_PARAMETER, id)
        UserRecord userRecord = dslContext.fetchOne(USER, USER.ID.equal(idParam))
        userRecord.setDateofbirth(user.getDateOfBirth())
        userRecord.setName(user.getName())
        return userRecord.store()
    }

    User deleteUser(int id) {
        Param<Integer> idParam = DSL.param(ID_PARAMETER, id)
        UserRecord userRecord = dslContext.fetchOne(USER, USER.ID.equal(idParam))
        userRecord.delete()
        return userRecord.into(User)
    }
}

