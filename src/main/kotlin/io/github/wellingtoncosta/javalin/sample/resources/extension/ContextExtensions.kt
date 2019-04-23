package io.github.wellingtoncosta.javalin.sample.resources.extension

import io.javalin.Context


/**
 * @author Wellington Costa on 21/01/19
 */

fun Context.paramAsLong(pathParam: String) = this.pathParam(pathParam).toLong()
