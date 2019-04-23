package io.github.wellingtoncosta.javalin.sample.domain.repository

import io.github.wellingtoncosta.javalin.sample.domain.entity.User


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