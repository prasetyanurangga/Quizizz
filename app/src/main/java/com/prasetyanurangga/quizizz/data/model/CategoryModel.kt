package com.prasetyanurangga.quizizz.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "category"
)
data class CategoryModel(
    @PrimaryKey(
        autoGenerate = true
    )
    @ColumnInfo( name = "id" )
    val ID: Int,

    @ColumnInfo( name = "name" )
    val name: String,

    @ColumnInfo( name = "image" )
    val image: String? = null
)