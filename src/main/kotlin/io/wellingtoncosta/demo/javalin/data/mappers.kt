package io.wellingtoncosta.demo.javalin.data

import io.wellingtoncosta.demo.javalin.domain.User
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
