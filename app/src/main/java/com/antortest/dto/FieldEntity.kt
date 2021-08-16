package com.antortest.dto

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class FieldEntity(

    val fieldString: String,
    @PrimaryKey(autoGenerate = true)
    val fieldInt: Int,
    val fieldDouble: Double

) {
    fun toDto() = Fields(fieldString, fieldInt, fieldDouble, showString = false, showInt = false, showDouble = false)


    companion object {
        fun fromDto(dto: Fields) =
            FieldEntity(dto.fieldString, dto.fieldInt, dto.fieldDouble)
    }
}

fun List<FieldEntity>.toDto(): List<Fields> = map(FieldEntity::toDto)
fun List<Fields>.toEntity(): List<FieldEntity> = map(FieldEntity::fromDto)