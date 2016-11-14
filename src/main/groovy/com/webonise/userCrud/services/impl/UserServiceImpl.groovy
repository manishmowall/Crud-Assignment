package com.webonise.userCrud.services.impl

import com.google.inject.Inject
import com.webonise.userCrud.daos.UserDao
import com.webonise.userCrud.exceptions.ValidationException
import com.webonise.userCrud.pojos.UserPojo
import com.webonise.userCrud.services.interfaces.UserService
import com.webonise.userCrud.tables.pojos.User
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j

import java.sql.Timestamp

@Slf4j
@CompileStatic
class UserServiceImpl implements UserService {
    private final UserDao userDao

    @Inject
    UserServiceImpl(UserDao userDao) {
        this.userDao = userDao
    }

    @Override
    List<User> getAllUsers() {
        return userDao.getAllUsers()
    }

    @Override
    int updateUser(int id, UserPojo user) {
        if (!isValidName(user.getName()) || !isValidDate(user.getDateOfBirth())) {
            log.error("Name or date not present")
            throw new ValidationException("Name or date not present")
        }
        return userDao.updateUser(id, user)
    }

    private boolean isValidDate(Timestamp date) {
        return date != (Timestamp) null
    }

    private boolean isValidName(String name) {
        return name != null
    }

    @Override
    User saveUser(UserPojo user) {
        return userDao.saveUser(user)
    }

    @Override
    User deleteUser(int id) {
        return userDao.deleteUser(id)
    }
}
