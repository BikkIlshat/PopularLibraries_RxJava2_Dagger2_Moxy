package com.hfad.popularlibrariesrxjava2dagger2moxy.di.modules

import android.content.Context
import androidx.room.Room
import com.hfad.popularlibrariesrxjava2dagger2moxy.model.storage.RoomDB
import dagger.Module
import dagger.Provides

@Module
class StorageModule {

    @Provides
    fun provideGithubStorageDatabase(context: Context): RoomDB =
        Room.databaseBuilder(context, RoomDB::class.java, "github.db").build()
}
