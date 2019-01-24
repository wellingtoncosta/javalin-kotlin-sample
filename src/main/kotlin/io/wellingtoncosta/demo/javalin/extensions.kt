package io.wellingtoncosta.demo.javalin

import io.javalin.Context


/**
 * @author Wellington Costa on 21/01/19
 */

fun Context.paramAsLong(pathParam: String) = this.pathParam(pathParam).toLong()
