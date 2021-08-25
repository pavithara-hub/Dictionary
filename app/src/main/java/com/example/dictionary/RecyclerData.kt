package com.example.dictionary

import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RecyclerData(
    @PrimaryKey(autoGenerate = true)
    var id:Int,

    @Expose
    @SerializedName("word")
    var word: String,

    @Expose
    @SerializedName("synonyms")
    val synonyms: String,

    @Expose
    @SerializedName("example")
    val example: String

) {

    @JvmName("getId1")
    fun getId(): Int {
        return id
    }

    @JvmName("getWord1")
    fun getWord(): String? {
        return word
    }
}