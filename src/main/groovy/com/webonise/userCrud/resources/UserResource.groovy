package com.webonise.userCrud.resources

import com.google.inject.Inject
import com.webonise.userCrud.pojos.UserPojo
import com.webonise.userCrud.services.interfaces.UserService
import com.webonise.userCrud.tables.pojos.User
import groovy.transform.CompileStatic
import org.restlet.resource.Delete
import org.restlet.resource.Get
import org.restlet.resource.Post
import org.restlet.resource.Put
import org.restlet.resource.ServerResource

@CompileStatic
class UserResource extends ServerResource {
    private static final String USER_ID = "userid"
    private final UserService userService

    @Inject
    UserResource(UserService userService) {
        this.userService = userService
    }

    @Get
    List<User> getAllUsers() {
        return userService.getAllUsers()
    }

    @Post
    User saveUser(UserPojo user) {
        return userService.saveUser(user)
    }

    @Put
    int updateUser(UserPojo user) {
        int id = Integer.parseInt(getQuery().getValues(USER_ID))
        return userService.updateUser(id, user)
    }

    @Delete
    User deleteUser() {
        int id = Integer.parseInt(getQuery().getValues(USER_ID))
        return userService.deleteUser(id)
    }
}
