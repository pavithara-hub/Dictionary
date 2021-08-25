package com.example.dictionary.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface FavoriteDao {

    @Insert
    fun addData(favoriteListData: FavoriteListData?)

    @Query("select * from favoritelistData")
    fun getFavoriteData(): List<FavoriteListData?>?

    @Query("SELECT EXISTS (SELECT 1 FROM favoritelistData WHERE id=:id)")
    fun isFavorite(id: Int): Int

    @Delete
    fun delete(favoriteListData: FavoriteListData?)


}