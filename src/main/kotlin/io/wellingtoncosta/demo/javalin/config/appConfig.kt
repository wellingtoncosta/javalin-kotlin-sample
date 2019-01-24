package io.wellingtoncosta.demo.javalin.config

import io.javalin.Javalin
import io.javalin.JavalinEvent.SERVER_STOPPING
import io.wellingtoncosta.demo.javalin.web.Router
import org.eclipse.jetty.http.HttpStatus
import org.koin.standalone.KoinComponent
import org.koin.standalone.StandAloneContext
import org.koin.standalone.inject
import org.slf4j.LoggerFactory

/**
 * @author Wellington Costa on 23/01/19
 */

class App : KoinComponent {

    private val router: Router by inject()

    fun setup(): Javalin {
        StandAloneContext.startKoin(appModules)
        return Javalin.create()
            .also { app ->
                app.enableCorsForAllOrigins()
                app.event(SERVER_STOPPING) { StandAloneContext.stopKoin() }
                router.register(app)
                app.port(7000)
            }
    }

}