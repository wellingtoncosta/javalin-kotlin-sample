package io.github.wellingtoncosta.javalin.sample.app.web

import io.javalin.Handler
import io.github.wellingtoncosta.javalin.sample.domain.entity.User
import io.github.wellingtoncosta.javalin.sample.domain.repository.UserRepository
import io.github.wellingtoncosta.javalin.sample.resources.extension.paramAsLong

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