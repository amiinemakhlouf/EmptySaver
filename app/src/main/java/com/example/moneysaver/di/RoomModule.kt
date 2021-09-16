package com.example.moneysaver.di

import android.content.Context
import androidx.room.Room
import com.example.moneysaver.data.db.ClientDao
import com.example.moneysaver.data.db.ExpensesDao
import com.example.moneysaver.data.db.MoneySaverDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.internal.managers.ApplicationComponentManager
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    @Singleton
    @Provides
    fun provideDB(@ApplicationContext context: Context): MoneySaverDatabase {

        return Room.databaseBuilder(
            context,
            MoneySaverDatabase::class.java,
            MoneySaverDatabase.DATABASE_NAME
        ).fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun provideExpenseDao(moneySaverDatabase: MoneySaverDatabase): ExpensesDao {
        return moneySaverDatabase.expensesDao()
    }

    @Singleton
    @Provides
    fun provideClientDao(moneySaverDatabase: MoneySaverDatabase): ClientDao {
        return moneySaverDatabase.clientDao()
    }


}

