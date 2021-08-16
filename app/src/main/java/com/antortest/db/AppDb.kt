package com.antortest.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.antortest.dao.FieldsDao
import com.antortest.dto.FieldEntity

@Database(entities = [FieldEntity::class], version = 1, exportSchema = false)
abstract class AppDb : RoomDatabase() {
    abstract fun fieldsDao(): FieldsDao

}