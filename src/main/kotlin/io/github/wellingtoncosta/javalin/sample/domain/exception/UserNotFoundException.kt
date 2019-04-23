package io.github.wellingtoncosta.javalin.sample.domain.exception

import java.lang.RuntimeException

class UserNotFoundException(id: Long) : RuntimeException("User with identifier $id was not found.")