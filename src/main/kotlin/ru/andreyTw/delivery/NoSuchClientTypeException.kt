package ru.andreyTw.delivery

class NoSuchClientTypeException(private val name: String) : Throwable() {
    override val message: String
        get() = "Client type \"$name\" not found in database!"
}
