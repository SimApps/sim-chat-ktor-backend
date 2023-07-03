package com.simapp.data

import com.simapp.data.model.Message

interface MessageDataSource {
    suspend fun getAllMessages(): List<Message>
    suspend fun insertMessage(message: Message)
}