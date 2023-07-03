package com.simapp.di

import com.simapp.data.MessageDataSource
import com.simapp.data.MessageDataSourceImpl
import com.simapp.room.RoomController
import org.koin.dsl.module
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

val mainModule = module {
    single {
      KMongo.createClient()
          .coroutine.getDatabase("message_db")
    }

    single<MessageDataSource> {
        MessageDataSourceImpl(get())
    }

    single {
        RoomController(get())
    }
}