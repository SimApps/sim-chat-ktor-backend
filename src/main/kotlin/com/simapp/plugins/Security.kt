package com.simapp.plugins

import com.simapp.sessions.ChatSession
import io.ktor.server.sessions.*
import io.ktor.server.response.*
import io.ktor.server.application.*
import io.ktor.server.routing.*
import io.ktor.util.*

fun Application.configureSecurity() {
    install(Sessions) {
        cookie<ChatSession>("MY_SESSION")
    }

    intercept(ApplicationCallPipeline.Plugins){
        if(call.sessions.get<ChatSession>() == null){
            val username = call.parameters["username"] ?: "Guest"
            call.sessions.set(ChatSession(username = username, sessionId = generateNonce()))
        }
    }
}


