package com.antortest.repository

import androidx.lifecycle.map
import com.antortest.dao.FieldsDao
import com.antortest.dto.FieldEntity
import com.antortest.dto.Fields
import com.antortest.dto.toDto
import com.antortest.dto.toEntity
import javax.inject.Inject

class FieldsRepositoryImpl @Inject constructor(
    private val dao: FieldsDao
) : FieldsRepository {

    override val dataFields = dao.getAll().map(List<FieldEntity>::toDto)

    override suspend fun insert(listFields: List<Fields>) {
        dao.insert(listFields.toEntity())
    }


}

