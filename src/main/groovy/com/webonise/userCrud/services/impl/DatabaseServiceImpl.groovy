package com.webonise.userCrud.services.impl

import com.google.inject.Inject
import com.webonise.userCrud.daos.UserDao
import com.webonise.userCrud.pojos.UserPojo
import com.webonise.userCrud.services.interfaces.DatabaseService
import groovy.transform.CompileStatic

@CompileStatic
class DatabaseServiceImpl implements DatabaseService {

    @Inject
    UserDao userDao

    @Override
    List<UserPojo> findAllUsers() {
        return userDao.findAllUsers()
    }

    @Override
    int updateUser(UserPojo user) {
        return userDao.updateUser(user)
    }

    @Override
    int saveUser(UserPojo user) {
        return userDao.saveUser(user)
    }

    @Override
    int deleteUser(int id) {
        return userDao.deletUser(id)
    }
}
