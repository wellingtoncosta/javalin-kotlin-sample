package io.github.wellingtoncosta.javalin.sample.app.config

import io.github.wellingtoncosta.javalin.sample.resources.repository.UserDatabaseRepository
import io.github.wellingtoncosta.javalin.sample.domain.repository.UserRepository
import io.github.wellingtoncosta.javalin.sample.app.web.UserRouter
import io.github.wellingtoncosta.javalin.sample.app.web.UserController
import org.koin.dsl.module.module

/**
 * @author Wellington Costa on 23/01/19
 */

val configModule = module {
    single { App() }
    single { DatabaseConfig(jdbcUrl, jdbcDriver, dbUsername, dbPassword).dataSource }
    single { UserRouter(get()) }
}

val userModule = module {
    single { UserDatabaseRepository(get()) as UserRepository }
    single { UserController(get()) }
}

val appModules = listOf(configModule, userModule)