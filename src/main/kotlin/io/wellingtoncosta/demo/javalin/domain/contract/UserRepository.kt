package io.wellingtoncosta.demo.javalin.domain.contract

import io.wellingtoncosta.demo.javalin.domain.model.User


/**
 * @author Wellington Costa on 21/01/19
 */
interface UserRepository {

    fun getAll(): List<User>

    fun getOne(id: Long): User

    fun create(user: User): User

    fun update(id: Long, user: User): User

    fun delete(id: Long)

}