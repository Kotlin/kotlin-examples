package org.example.vertxwebservices

enum class StatusCode(val num: Int) {
    OK(200),
    CLIENT_ERROR(400),
    NOT_FOUND(404),
    SERVER_ERROR(500)
}