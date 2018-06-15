package com.serverless.handler.aws

import com.serverless.functions.HelloRequest
import com.serverless.functions.HelloResponse
import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler

/**
 * This handler is used for invoking lambda functions directly
 */
class HelloHandler() : SpringBootRequestHandler<HelloRequest, HelloResponse>()