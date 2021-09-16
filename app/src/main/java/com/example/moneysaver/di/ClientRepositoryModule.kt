package com.example.moneysaver.di

import com.example.moneysaver.data.db.ClientDao
import com.example.moneysaver.data.db.MoneySaverDatabase
import com.example.moneysaver.repostories.ClientRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.internal.managers.ApplicationComponentManager
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
@InstallIn(SingletonComponent::class)
@Module
object ClientRepositoryModule {
    @Singleton
    @Provides
    fun provideClientRepository(db:ClientDao):ClientRepository
    {
        return ClientRepository(db)   }
}