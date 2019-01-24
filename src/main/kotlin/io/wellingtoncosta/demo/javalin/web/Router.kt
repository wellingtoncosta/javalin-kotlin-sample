package io.wellingtoncosta.demo.javalin.web

import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.*

/**
 * @author Wellington Costa on 21/01/19
 */
class Router(
    private val controller: UserController
)  {

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
