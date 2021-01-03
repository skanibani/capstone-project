package com.example.sherlock.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Item(
        @ColumnInfo(name = "brand")
        var brand: String,
        @ColumnInfo(name = "category")
        var category: String,
        @ColumnInfo(name = "description")
        var description: String,
        @ColumnInfo(name = "details")
        var details: String,
        @ColumnInfo(name = "material")
        var material: String,
        @ColumnInfo(name = "ownerName")
        var ownerName: String,
        @ColumnInfo(name = "location")
        var location : String,
        // TODO make location list

        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id")
        var id: Long? = null
)
