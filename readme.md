# Kotlin Gradle Spring Cloud Function Serverless Template

This is a boilerplate template for [serverless](https://serverless.com/) using 
[Spring Cloud Function](https://cloud.spring.io/spring-cloud-function/). It uses 
Kotlin, Gradle and AWS but could be easily adapted.

I also have a non-spring template [aws-kotlin-jvm-gradle](https://github.com/jswift/aws-kotlin-jvm-gradle) which is included
with the serverless distribution.

## Requirements
 - Serverless 1.24 or higher
 - Gradle 4 and JDK8 
 
## Usage
```bash
# Create template
serverless create --template-url https://github.com/jswift/aws-kotlin-jvm-spring \
    --path helloworld --name hello && cd helloworld

# Build and deploy the hello world function
gradle deploy
```

### Functions
There are a few ways to define functions in Spring Cloud Function, the method used here is to create
classes that implement `Function` and use the auto scan feature. Spring will scan the `com.serverless.functions`
namespace (defined in application.properties) for functions.

### Handlers
Each function need's a corresponding _handler_ class, unless the function will be accessed only by a http event (in 
which case it can use the `ApiGatewayHandler`).

### Requests
Functions consume and produce plain java objects. When using the ApiGatewayHandler, functions can access the full details of the request (e.g. the headers and
path variables) by wrapping the request object in Spring's `Message` object.

```kotlin
fun apply(t: Message<HelloRequest>): HelloResponse {
    val httpRequest = req.headers["request"] as? APIGatewayProxyRequestEvent ?: return HelloResponse("Failed to get request event")
    
    // Read headers, etc
    
    return HelloResponse("Hello, ${t.name ?: "World"}")
}
```
 
