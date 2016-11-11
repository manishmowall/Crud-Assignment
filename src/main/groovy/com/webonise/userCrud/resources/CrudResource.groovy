package com.webonise.userCrud.resources

import com.google.inject.Inject
import com.webonise.userCrud.pojos.UserPojo
import com.webonise.userCrud.services.interfaces.DatabaseService
import groovy.transform.CompileStatic
import org.restlet.resource.Delete
import org.restlet.resource.Get
import org.restlet.resource.Post
import org.restlet.resource.Put
import org.restlet.resource.ServerResource

@CompileStatic
class CrudResource extends ServerResource {

    @Inject
    DatabaseService databaseService;

    @Get
    List<UserPojo> findAllUsers() {
        return databaseService.findAllUsers()
    }

    @Post
    int saveUser(UserPojo user) {
        return databaseService.saveUser(user)
    }

    @Put
    int updateUser(UserPojo user) {
        int id = Integer.parseInt(getQuery().getValues("userId"))
        user.setId(id)
        return databaseService.updateUser(user)
    }

    @Delete
    String deleteUser() {
        int id = Integer.parseInt(getQuery().getValues("userId"))
        return databaseService.deleteUser(id)
    }
}
