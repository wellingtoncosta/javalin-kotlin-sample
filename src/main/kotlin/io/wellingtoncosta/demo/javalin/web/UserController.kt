package io.wellingtoncosta.demo.javalin.web

import io.javalin.Handler
import io.wellingtoncosta.demo.javalin.domain.User
import io.wellingtoncosta.demo.javalin.domain.UserRepository
import io.wellingtoncosta.demo.javalin.paramAsLong


/**
 * @author Wellington Costa on 21/01/19
 */
class UserController(
    private val repository: UserRepository
) {

    fun getAll() = Handler { it.json(repository.getAll()) }

    fun getOne() = Handler { it.json(repository.getOne(it.paramAsLong("id"))) }

    fun create() = Handler { it.json(repository.create(it.bodyAsClass(User::class.java))) }

    fun update() = Handler {
        val id = it.paramAsLong("id")
        val user = it.bodyAsClass(User::class.java)
        it.json(repository.update(id, user))
    }

    fun delete() = Handler {
        repository.delete(it.paramAsLong("id"))
        it.status(204)
    }

}