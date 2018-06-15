package com.serverless.functions

import java.util.function.Function

class Hello : Function<HelloRequest, HelloResponse> {
    override fun apply(request: HelloRequest) = HelloResponse("Hello, ${request.name ?: "World"}!")
}

class HelloRequest(var name: String? = null)

class HelloResponse(val message: String)