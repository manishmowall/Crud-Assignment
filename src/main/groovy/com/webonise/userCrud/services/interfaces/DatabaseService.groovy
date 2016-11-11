package com.webonise.userCrud.services.interfaces

import com.webonise.userCrud.pojos.UserPojo
import groovy.transform.CompileStatic

@CompileStatic
public interface DatabaseService {
    List<UserPojo> findAllUsers()

    int updateUser(UserPojo user)

    int saveUser(UserPojo user)

    int deleteUser(int id)
}
