package com.mukesh.module.domain.model.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
Created by Mukesh on 17/10/22
 **/

@Entity(tableName = "news_language")
data class NewsLanguage(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "pk")
    val pk: Long = 0,

    @ColumnInfo(name = "categoryId")
    val languageId: String,

    @ColumnInfo(name = "categoryName")
    val languageName: String?
)
