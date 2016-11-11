package com.webonise.userCrud.daos

import com.google.inject.Inject
import com.webonise.userCrud.pojos.UserPojo
import com.webonise.userCrud.tables.records.UserRecord
import groovy.transform.CompileStatic
import org.jooq.DSLContext
import org.jooq.Record
import org.jooq.Result

import static com.webonise.userCrud.tables.User.USER

@CompileStatic
class UserDao {

    @Inject
    DSLContext dslContext;

    List<UserPojo> findAllUsers() {
        Result<Record> result = dslContext.select().from(USER).fetch()

        List<UserPojo> users = new ArrayList()
        for (Record record : result) {
            int id = record.getValue(USER.ID)
            String name = record.getValue(USER.NAME)
            int age = record.getValue(USER.AGE)
            UserPojo user = new UserPojo(id, name, age)
            users.add(user)
        }

        return users
    }

    int saveUser(UserPojo user) {
        int status = dslContext.insertInto(USER, USER.NAME, USER.AGE).values(user.getName(), user.getAge()).execute()

        return status
    }

    int updateUser(UserPojo user) {
        UserRecord userRecord = dslContext.fetchOne(USER, USER.ID.equal(user.getId()))

        if (isValidValue(user.getAge())) {
            userRecord.setAge(user.getAge())
        }

        if (isValidValue(user.getName())) {
            userRecord.setName(user.getName())
        }

        return userRecord.store()
    }

    private boolean isValidValue(int age) {
        return age != 0;
    }

    private boolean isValidValue(String name) {
        return name != null;
    }

    int deletUser(int id) {

        int status = dslContext.delete(USER).where(USER.ID.equal(id)).execute()

        return status
    }
}

