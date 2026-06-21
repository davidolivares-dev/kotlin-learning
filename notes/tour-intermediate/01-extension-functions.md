# Tour Extension Functions

Extension functions let you add functionality to a class without modifying its source code. You call them the same way as member functions using `.`.

## Receiver

The receiver is the object an extension function is called on. Inside the function body, the receiver is accessed via `this`.

```kotlin
fun String.bold(): String = "<b>$this</b>"

println("hello".bold()) // <b>hello</b>
```

Here `String` is the receiver type, `"hello"` is the receiver instance, and `this` inside the body refers to that instance.

## Extension-oriented Design

Extension functions can be defined anywhere, which lets you separate core functionality from non-essential features. This keeps classes focused while still providing convenience APIs.

A good example is the `HttpClient` class from the Ktor library. Its core is a single `request()` function:

```kotlin
class HttpClient {
    fun request(method: String, url: String, headers: Map<String, String>): HttpResponse {
        // Network code
    }
}
```

GET and POST don't need new network code — they're just specific `request()` calls. Extension functions are the right fit:

```kotlin
fun HttpClient.get(url: String): HttpResponse = request("GET", url, emptyMap())
fun HttpClient.post(url: String): HttpResponse = request("POST", url, emptyMap())
```

Because these extensions are called on a `HttpClient` instance as the receiver, they can call `request()` directly — `this.request()` is implied. This pattern is widely used in Kotlin's standard library and in libraries like Ktor.
