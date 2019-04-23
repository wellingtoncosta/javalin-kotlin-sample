package io.github.wellingtoncosta.javalin.sample.app.config

import io.javalin.Javalin
import io.javalin.JavalinEvent.SERVER_STOPPING
import io.github.wellingtoncosta.javalin.sample.domain.exception.UserNotFoundException
import io.github.wellingtoncosta.javalin.sample.app.web.UserRouter
import org.koin.standalone.KoinComponent
import org.koin.standalone.StandAloneContext
import org.koin.standalone.inject

/**
 * @author Wellington Costa on 23/01/19
 */

class App : KoinComponent {

    private val userRouter: UserRouter by inject()

    fun setup(): Javalin {
        StandAloneContext.startKoin(appModules)
        return Javalin.create()
            .also { app ->
                app.enableCorsForAllOrigins()
                app.event(SERVER_STOPPING) { StandAloneContext.stopKoin() }
                userRouter.register(app)
                app.exception(UserNotFoundException::class.java) { exception, ctx ->
                    ctx.status(404)
                    exception.message?.let { ctx.result(it) }
                }
                app.port(7000)
            }
    }

}
