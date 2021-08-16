package com.antortest.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.antortest.dto.FieldEntity


@Dao
interface FieldsDao {

    @Query("SELECT * FROM FieldEntity")
    fun getAll(): LiveData<List<FieldEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(field: List<FieldEntity>)

}