package com.mukesh.module.domain.model.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


/**
Created by Mukesh on 17/10/22
 **/

@Entity(tableName = "source")
data class Source(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "pk")
    var pk: Long = 0,

    @SerializedName("id")
    @ColumnInfo(name = "id")
    val id: String? = null,

    @SerializedName("category")
    @ColumnInfo(name = "category")
    val category: String? = null,

    @SerializedName("country")
    @ColumnInfo(name = "country")
    val country: String? = null,

    @SerializedName("description")
    @ColumnInfo(name = "description")
    val description: String? = null,

    @SerializedName("language")
    @ColumnInfo(name = "language")
    val language: String? = null,

    @SerializedName("name")
    @ColumnInfo(name = "name")
    val name: String? = null,

    @SerializedName("url")
    @ColumnInfo(name = "url")
    val url: String? = null

)

