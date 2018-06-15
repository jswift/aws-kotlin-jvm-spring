package com.serverless.handler.aws

import org.springframework.cloud.function.adapter.aws.SpringBootApiGatewayRequestHandler

/**
 * This handler allows simple handling of API gateway proxy requests.
 * To get access to the ApiGatewayProxyRequest object, wrap the request object with Message
 */
class ApiGatewayHandler() : SpringBootApiGatewayRequestHandler()