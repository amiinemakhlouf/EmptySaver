package com.example.moneysaver.di

import com.example.moneysaver.data.db.ExpensesDao
import com.example.moneysaver.data.db.MoneySaverDatabase
import com.example.moneysaver.data.room_repostories.ExpenseRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.internal.managers.ApplicationComponentManager
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
@InstallIn(SingletonComponent::class)
@Module
object ExpenseRepositoryModule {
    @Singleton
    @Provides
    fun provideExpenseRepository(db:ExpensesDao):ExpenseRepository
    {
        return ExpenseRepository(db)
    }
}