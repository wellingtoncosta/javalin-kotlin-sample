package io.github.wellingtoncosta.javalin.sample.resources.extension

import io.github.wellingtoncosta.javalin.sample.domain.entity.User
import io.github.wellingtoncosta.javalin.sample.resources.entity.UserTable
import org.jetbrains.exposed.sql.ResultRow

/**
 * @author Wellington Costa on 23/01/19
 */

fun ResultRow.toUserDomain() = User(
    id = this[UserTable.id],
    name = this[UserTable.name],
    email = this[UserTable.email],
    phone = this[UserTable.phone]
)
