package io.github.wellingtoncosta.javalin.sample.app.web

import io.github.wellingtoncosta.javalin.sample.app.web.UserController
import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.*

/**
 * @author Wellington Costa on 21/01/19
 */
class UserRouter(private val controller: UserController)  {

    fun register(app: Javalin) {
        app.routes {
            path("users") {
                get(controller.getAll())
                post(controller.create())
                path(":id") {
                    get(controller.getOne())
                    put(controller.update())
                    delete(controller.delete())
                }
            }
        }
    }

}
