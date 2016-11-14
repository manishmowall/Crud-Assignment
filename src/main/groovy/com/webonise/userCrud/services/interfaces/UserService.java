package com.webonise.userCrud.services.interfaces;

import com.webonise.userCrud.pojos.UserPojo;
import com.webonise.userCrud.tables.pojos.User;
import groovy.transform.CompileStatic;

import java.util.List;

@CompileStatic
public interface UserService {
    List<User> getAllUsers();

    int updateUser(int id, UserPojo user);

    User saveUser(UserPojo user);

    User deleteUser(int id);
}
