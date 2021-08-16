package com.antortest.dao

import com.antortest.db.AppDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
class FieldsDaoModule {
    @Provides
    fun provideFieldsDao(db: AppDb): FieldsDao = db.fieldsDao()
}