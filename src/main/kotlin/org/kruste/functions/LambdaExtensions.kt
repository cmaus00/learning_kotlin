package org.kruste.functions

data class Request(val method: String, val path: String, val query: String)
data class Response(var content: String, var status: Status) {
    fun status(cb: Status.() -> Unit) = status.cb()
}

data class Status(var code: Int, var description: String)

class RouteHandlerContext(val req: Request, val resp: Response) {
    operator fun invoke(handler: RouteHandlerContext.() -> Unit) {
        this.handler()
    }

}

fun route(path: String, routeHandler: Response.() -> Unit): RouteHandlerContext.() -> Unit = {
    if (this.req.path == path) {
        this.resp.routeHandler()
    }
}

fun routes(vararg handlers: RouteHandlerContext.() -> Unit): RouteHandlerContext.() -> Unit = { handlers.forEach { it() } }


fun main(args: Array<String>) {

    val request = Request("GET", "/index", "")
    val rh = RouteHandlerContext(request, Response("", Status(404, "not found")))

    rh(
            routes(
                    route("/index") {
                        if (request.query.isEmpty()) {
                            content = "WTF"
                            status {
                                code = 403
                                description = "error"
                            }
                        }
                    },
                    route("narf") {
                        content ="Narf"
                        status {
                            code = 200
                            description = "OK"
                        }
                    }
            )
    )

    println(rh.resp)
}