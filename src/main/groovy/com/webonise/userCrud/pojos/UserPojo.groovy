package com.webonise.userCrud.pojos

import groovy.transform.Canonical

import java.sql.Timestamp

@Canonical
class UserPojo {
    String name
    Timestamp dateOfBirth
}
