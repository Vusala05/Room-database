package com.example.roomnew

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Contact")
data class  Contact(

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "surname")
    val surname: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
