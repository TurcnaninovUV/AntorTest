package com.antortest.repository

import androidx.lifecycle.LiveData
import com.antortest.dto.Fields

interface FieldsRepository {

    val dataFields: LiveData<List<Fields>>

    suspend fun insert(listFields : List<Fields>)



}