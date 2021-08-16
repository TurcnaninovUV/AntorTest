package com.antortest.repository

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
abstract class FieldsRepositoryModule {

    @Binds
    @Singleton
    abstract fun bindFieldsRepository(impl: FieldsRepositoryImpl): FieldsRepository
}