package io.github.wellingtoncosta.javalin.sample.resources.entity

import org.jetbrains.exposed.sql.Table

/**
 * @author Wellington Costa on 23/01/19
 */
object UserTable : Table() {

    val id = long("id").primaryKey().autoIncrement()
    val name = varchar("name", 50)
    val email = varchar("email", 50)
    val phone = varchar("phone", 30).nullable()

}
