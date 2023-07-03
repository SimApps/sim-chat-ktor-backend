package com.simapp.plugins

import com.simapp.room.RoomController
import com.simapp.routes.chatSocket
import com.simapp.routes.getAllMessages
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    val roomController by inject<RoomController>()
    install(Routing){
        chatSocket(roomController = roomController)
        getAllMessages(roomController = roomController)
    }
}
