package com.example.dictionary.database


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favoritelistData")
data class FavoriteListData(
    @PrimaryKey(autoGenerate = true)
    var id: Int,

    @ColumnInfo(name = "word")
    var word: String? = null

){
    @JvmName("setId1")
    fun setId(id: Int) {
        this.id = id
    }
    @JvmName("getId1")
    fun getId(): Int {
        return id
    }

    @JvmName("getWord1")
    fun getWord(): String? {
        return word
    }

    @JvmName("setWord1")
    fun setWord(word: String) {
        this.word=word

    }


}