package io.wellingtoncosta.demo.javalin.config

import io.wellingtoncosta.demo.javalin.data.UserDataRepository
import io.wellingtoncosta.demo.javalin.domain.UserRepository
import io.wellingtoncosta.demo.javalin.web.Router
import io.wellingtoncosta.demo.javalin.web.UserController
import org.koin.dsl.module.module

/**
 * @author Wellington Costa on 23/01/19
 */

val configModule = module {
    single { App() }
    single { DatabaseConfig(jdbcUrl, jdbcDriver, dbUsername, dbPassword).dataSource }
    single { Router(get()) }
}

val userModule = module {
    single { UserDataRepository(get()) as UserRepository }
    single { UserController(get()) }
}

val appModules = listOf(configModule, userModule)